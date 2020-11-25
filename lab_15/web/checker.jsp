<jsp:useBean id="ip" scope="application" type="java.lang.String"/>
<%@ page import="db.Connect" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    //String ip = (String) request.getAttribute("ip");
%>

<html>
<head>
    <title>Checking...</title>
</head>
<body>
    <%
        String fulname = "";
        int user_id = 0;
        Connection connection = Connect.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"password\" inner join \"name\" N on password.id = N.id where login = '"+login+"' and \"password\".password = '"+password+"'");
            while (rs.next()){
            	user_id=rs.getInt(rs.getInt(1));
                fulname+=rs.getString(5)+" "+rs.getString(6);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(!fulname.isEmpty()){
            out.print("<h1>Hello, "+fulname+"</h1>");
            PreparedStatement ps,ps2;
            try {
                ps=connection.prepareStatement("INSERT INTO \"log\"(user_id,ip,log_date) VALUES (?,?,?)");
                ps.setInt(1,user_id);
                ps.setString(2, (String) getServletConfig().getServletContext().getAttribute("ip"));

//                long epoch = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse("01/01/1970 01:00:00").getTime() / 1000;
//                String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (epoch*1000));

//                LocalDate today = LocalDate.now();
//                java.sql.Date sqlDate = java.sql.Date.valueOf( today );

                ps.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
                ps.execute();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
            	ps2 = connection.prepareStatement("UPDATE \"enterycount\" SET \"entery_count\"= \"enterycount\".\"entery_count\"+1 where \"id\" = "+user_id);
            	ps2.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            out.print("<h1>No such account found! Try again!</h1>");
        }
    %>
    <p>Ip: ${applicationScope.get("ip")}</p>
</body>
</html>

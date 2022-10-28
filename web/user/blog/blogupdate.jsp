<%-- 
    Document   : blogDetails
    Created on : Oct 18, 2022, 1:47:50 PM
    Author     : nguye
--%>
<%@include file="/store/layout/index.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            * {
                box-sizing: border-box;
            }

            body {
                font-family: Arial;
                padding: 20px;
                background: #f1f1f1;
            }
            p {
                margin-top: 20px;

            }
            /* Header/Blog Title */
            .header {
                padding: 30px;
                font-size: 40px;
                text-align: center;
                background: white;
            }

            /* Create two unequal columns that floats next to each other */
            /* Left column */
            .leftcolumn {
                /*                float: left;*/
                width: 75%;
                margin: auto;
            }



            /* Fake image */
            .fakeimg {
                /*  background-color: #aaa;*/
                width: 100%;
                padding: 20px;
            }

            /* Add a card effect for articles */
            .card {
                border-radius: 20px;
                background-color: white;
                padding: 20px;
                margin-top: 20px;

            }
            .card2 {
                background-color: white;
                padding: 20px;
                margin-top: 20px;

            }

            /* Clear floats after the columns */
            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Footer */
            .footer {
                padding: 20px;
                text-align: center;
                background: #ddd;
                margin-top: 20px;
            }
            .middle{
                margin-left: 200px;
            }
            .img {
                
                height: 20px;
                width: 20px;
            }
            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
            @media screen and (max-width: 800px) {
                .leftcolumn, .rightcolumn {
                    width: 100%;
                    padding: 0;
                }
            }


        </style>
    </head>
    <body>

        <div class="header">
            <h2>Blog Name</h2>
        </div>

        <div class="row">
            <div class="leftcolumn">

                <div class="card2">
                    <<form action="userBlogUpdate" method="POST">
                    <h2> <input style=" width: 1000px;" value=" ${requestScope.blog.title}" name="title"></h2> 
                    <h5><textarea maxlength="255" style=" width: 1000px;" name="description">${requestScope.blog.description}</textarea></h5>
                    <h5>${requestScope.blog.create_at}</h5><br>
                    <div class="middle">
                        <img src="https://agencyentourage.com/wp-content/uploads/2018/02/thinkstockphotos-626669886.jpg" class="img-fluid avatar" style="max-height:700px; max-width: 75%;">
                        <input class="file-upload" type="file" id="img" name="img" accept="image/*" style="margin-top: 20px;">
                    </div>
                    <p><textarea maxlength="255" style=" width: 1000px;" name="content">${requestScope.blog.description}</textarea></p>

                    <input style="margin-bottom: 50px;"  class="btn btn-primary float-right" type="submit" value="Save">
</form>
                </div>

            </div>
        </div>
        <script >$(document).ready(function () {


                var readURL = function (input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            $('.avatar').attr('src', e.target.result);
                        }

                        reader.readAsDataURL(input.files[0]);
                    }
                }


                $(".file-upload").on('change', function () {
                    readURL(this);
                });
            });</script>
    </body>
</html>

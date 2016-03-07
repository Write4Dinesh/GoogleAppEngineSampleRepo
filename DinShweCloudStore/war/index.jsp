<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Dinesh Masthaiah</title>
    <!--REQUIRED STYLE SHEETS-->
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet" />
    <!-- VEGAS STYLE CSS -->
    <link href="assets/scripts/vegas/jquery.vegas.min.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Ruluko' rel='stylesheet' type='text/css' />
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ page import="java.util.*"%>
	<%
   Date date = new Date();
   out.print( "<h2 align=\"left\">Today's Date:" +date.toString()+"</h2>");
%>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="login.jsp">My Private Login </a>
            </div>
            <!-- Collect the nav links for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#home">About Me</a>
                    </li>
                    <li><a href="#services">Professional Services</a>
                    </li>

                    <li><a href="#price-sec">Work Experience</a>
                    </li>

                    <li><a href="#contact-sec">Contact Me</a>
                    </li>
                    <li><a href="#"><strong>e-mail:</strong>  dinesh.masthaiah@gmail.com</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!--End Navigation -->


    <!--Header section  -->
    <div class="container" id="home">
        <div class="row text-center">
            <div class="col-md-12">
                <h1 class="head-main">DINESH MASTHAIAH</h1>
                <h2 class="head-sub-main">Software Consultant,Architect</h2>
                <a class="btn btn-danger btn-lg " href="#about">Read More About Me </a><a class="btn btn-default btn-lg" href="#contact-sec">Leave Comment About Me</a>
                <div class="head-last"></div>

            </div>


        </div>
    </div>
    <!--End Header section  -->
 <!-- Section 2-My Hobby-->
    <section class="for-full-back color-white" id="about">
        <div class="container">

            
                
            <div class="row text-center">
                <div class="col-md-12">
                    <h2>More about me goes here...</h2>
                    <p>
                        Detailed info about me goes here..
                    </p>
                </div>

            </div>
        </div>


    </section>

    <!-- Section 2-My Hobby-->
    <section class="for-full-back color-white" id="services">
        <div class="container">

            <div class="row text-center">
                <div class="col-md-8 col-md-offset-2">
                    <h1>Professional Services</h1>
                    <h4>
                        <strong>List of professional services offered  goes here..
                        </strong>
                    </h4>
                </div>

            </div>

            <div class="row text-center space-pad">
                <div class="col-md-3 ">

                    <div class="about-div">

                        <i class="fa fa-camera fa-4x main-color-red"></i>


                        <h3>Service1 </h3>
                        <p>
                            Description about Service1
                        </p>

                    </div>

                </div>
                <div class="col-md-3 ">

                    <div class="about-div">

                        <i class="fa fa-briefcase fa-4x main-color-red"></i>


                        <h3>Service2</h3>
                        <p>
                            Description about Service2
                        </p>

                    </div>

                </div>
                <div class="col-md-3 ">

                    <div class="about-div">

                        <i class="fa fa-desktop fa-4x main-color-red"></i>


                        <h3>Service3</h3>
                        <p>
                            Description about Service3
                        </p>

                    </div>

                </div>
                <div class="col-md-3 ">

                    <div class="about-div">

                        <i class="fa fa-folder fa-4x main-color-red"></i>


                        <h3>Service4 </h3>
                        <p>
                            Description  about Service4
                        </p>

                    </div>

                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-12">
                    <h2>More about Professional Services</h2>
                    <p>
                        More about Services and interests goes here.....
                    </p>
                </div>

            </div>
        </div>


    </section>

    <section class="for-full-back " id="Parallax-one">
        <div class="container">

            <div class="row text-center for-parallax-one">
                <div class="col-md-6 ">
                    <h3>Technologies worked With</h3>
                    <h4>
                        <strong>List of Technologies goes here....
                        </strong>
                    </h4>
                </div>
                <div class="col-md-6 ">
                    <h3>Industries Worked With</h3>
                    <h4>
                        <strong>List of Industries goes here...
                        </strong>
                    </h4>
                </div>
            </div>


        </div>
    </section>
    <!--./parallax one-->
    <!--End words Section-->




    <!-- Section3-My Hobby -->

    <section class="for-full-back color-white " id="price-sec">
        <div class="container">
            <div class="row text-center">
                <div class="col-md-8 col-md-offset-2">
                    <h1>My Career</h1>
                    <h4>
                        <strong>Experience description goes here..
                        </strong>
                    </h4>
                </div>

            </div>
            <div class="row text-center">

                <div class="col-md-12 ">



                    <div class="col-md-3">
                        <ul class="plan">
                            <li class="plan-head">Mobile Apps Development</li>
                            <li class="main-price">Skill Description</li>
                            <li>more about Skill...</li>
                            <li class="bottom">
                                <a href="#contact-sec" class="btn btn-default">Read More</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-3">
                        <ul class="plan">
                            <li class="plan-head">Web Development</li>
                            <li class="main-price">Skill Description</li>
                            <li>more about Skill...</li>
                            <li class="bottom">
                                <a href="#contact-sec" class="btn btn-default">Read More</a>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-3">
                        <ul class="plan">
                            <li class="plan-head">Server-side Development</li>
                            <li class="main-price">Skill Description</li>
                            <li>more about Skill...</li>
                            <li class="bottom">
                                <a href="#contact-sec" class="btn btn-default">Read More</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-3">
                        <ul class="plan">
                            <li class="plan-head">Desktop Apps Development</li>
                            <li class="main-price">Skill Description</li>
                            <li>more about Skill...</li>
                            <li class="bottom">
                                <a href="#contact-sec" class="btn btn-default">Read More</a>
                            </li>
                        </ul>
                    </div>

                </div>
            </div>


        </div>
    </section>
<!-- Section 4. Contact Me... -->
    <section class="for-full-back for-parallax-two" id="Parallax-two">
        <div class="container">

            <div class="row text-center">
                <div class="col-md-8 col-md-offset-2 ">
                    <h1>Contact Me</h1>
                    <h4>
                        <strong>More About why and how you can contact me
                        </strong>
                    </h4>
                </div>

            </div>


        </div>
    </section>
    <!--./parallax two-->
    <!--End Pricing Section -->

    <!-- Contact Section -->
    <section class="for-full-back color-white " id="contact-sec">
        <div class="container">


            <div class="row">
                <div class="col-md-5 contact-cls">
                    <h3>CONTACT ME </h3>
                    <div>
                        <span><i class="fa fa-home"></i>&nbsp; Address: Bangalore City,Karnataka,India.</span>
                        <br />
                        <span><i class="fa fa-phone"></i>&nbsp;Phone: tell you soon...</span>
                        <br />
                        <span><i class="fa fa-envelope-o"></i>&nbsp;E-Mail: dinesh.masthaiah@gmail.com</span>
                        <br />
                        <span><i class="fa fa-phone"></i>&nbsp;Call: tell you soon</span>
                        <br />
                        <span><i class="fa fa-globe"></i>&nbsp;Web: www.iamdineshmasthaiah.com</span>
                        <br />
                    </div>
                    <br />
                    <div id="social-icon">
                        <a href="#"><i class="fa fa-facebook fa-2x"></i></a>
                        <a href="#"><i class="fa fa-twitter fa-2x"></i></a>
                        <a href="#"><i class="fa fa-linkedin fa-2x"></i></a>
                        <a href="#"><i class="fa fa-google-plus fa-2x"></i></a>
                        <a href="#"><i class="fa fa-pinterest fa-2x"></i></a>
                    </div>
                </div>
                <div class="col-md-7">
                    <h2>Leave your comment here</h2>
                    <p>
                       Please write your comment about this site.                    
                    </p>
                    <form>
                        <div class="row">
                            <div class="col-md-6 col-sm-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" required="required" placeholder="Name">
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" required="required" placeholder="Email address">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="form-group">
                                    <textarea name="message" id="message" required="required" class="form-control" rows="3" placeholder="Message"></textarea>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-default">Submit Comment</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </section>

    <!--End Contact Section -->
    <!--footer Section -->
    <div class="for-full-back " id="footer">
        2016 www.iamdineshmasthaiah.com | All Right Reserved
         
    </div>
    <!--End footer Section -->
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="assets/plugins/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP CORE SCRIPT   -->
    <script src="assets/plugins/bootstrap.js"></script>
    <!-- VEGAS SLIDESHOW SCRIPTS -->
    <script src="assets/plugins/vegas/jquery.vegas.min.js"></script>
    <script src="assets/plugins/jquery.parallax-1.1.3.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>

</body>
</html>

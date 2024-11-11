<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js" lang="en">

    <head>
        <script type="text/javascript">
            function pantallacompleta(pagina) {
                window.open(pagina, '', 'fullscreen=yes, scrollbars=auto');
            }
        </script> 
        <meta charset="utf-8">

        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>UNIVERSIDAD NACIONAL DE SAN CRISTÓBAL DE HUAMANGA</title>
        <meta name="description" content="Mango is a slick and responsive Admin Template build with modern techniques like HTML5 and CSS3 to be used for backend solutions of any size.">
        <meta name="author" content="Simon Stamm &amp; Markus Siemens">
        <!-- Mobile viewport optimized: h5bp.com/viewport -->
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <!-- iPhone: Don't render numbers as call links -->
        <meta name="format-detection" content="telephone=no">
        <link rel="shortcut icon" href="favicon.ico">

        <!-- ---------- -->
        <!-- Layout Styles -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/grid.css">
        <link rel="stylesheet" href="css/layout.css">
        <!-- Icon Styles -->
        <link rel="stylesheet" href="css/icons.css">
        <link rel="stylesheet" href="css/fonts/font-awesome.css">
        <!--[if IE 8]><link rel="stylesheet" href="css/fonts/font-awesome-ie7.css"><![endif]-->
        <!-- External Styles -->
        <link rel="stylesheet" href="css/external/jquery-ui-1.8.21.custom.css">
        <link rel="stylesheet" href="css/external/jquery.chosen.css">
        <link rel="stylesheet" href="css/external/jquery.cleditor.css">
        <link rel="stylesheet" href="css/external/jquery.colorpicker.css">
        <link rel="stylesheet" href="css/external/jquery.elfinder.css">
        <link rel="stylesheet" href="css/external/jquery.fancybox.css">
        <link rel="stylesheet" href="css/external/jquery.jgrowl.css">
        <link rel="stylesheet" href="css/external/jquery.plupload.queue.css">
        <link rel="stylesheet" href="css/external/syntaxhighlighter/shCore.css">
        <link rel="stylesheet" href="css/external/syntaxhighlighter/shThemeDefault.css">
        <!-- Elements -->
        <link rel="stylesheet" href="css/elements.css">
        <link rel="stylesheet" href="css/forms.css">
        <!-- OPTIONAL: Print Stylesheet for Invoice -->
        <link rel="stylesheet" href="css/print-invoice.css">
        <!-- Typographics -->
        <link rel="stylesheet" href="css/typographics.css">
        <!-- Responsive Design -->
        <link rel="stylesheet" href="css/media-queries.css">
        <!-- Bad IE Styles -->
        <link rel="stylesheet" href="css/ie-fixes.css">

        <!-- JavaScript at the top (will be cached by browser) -->
        <!-- Load Webfont loader -->
        <script type="text/javascript">
            window.WebFontConfig = {
                google: {families: ['PT Sans:400,700']},
                active: function() {
                    $(window).trigger('fontsloaded');
                }
            };
        </script>

        <!-- Essential polyfills -->
        <script src="js/mylibs/polyfills/modernizr-2.6.1.min.js"></script>
        <script src="js/mylibs/polyfills/respond.js"></script>
        <script src="js/mylibs/polyfills/matchmedia.js"></script>

        <!--[if lt IE 10]><script src="js/mylibs/polyfills/classlist.js"></script><![endif]-->
        <script src="js/libs/jquery-1.7.2.min.js"></script>
        <!-- Grab frameworks from CDNs -->

        <script src="js/libs/jquery-ui-1.8.21.min.js"></script>

        <script src="js/libs/lodash.min.js"></script>

        <script src="js/mylibs/jquery.hashchange.js"></script>
        <script src="js/mylibs/jquery.idle-timer.js"></script>
        <script src="js/mylibs/jquery.plusplus.js"></script>
        <script src="js/mylibs/jquery.jgrowl.js"></script>
        <script src="js/mylibs/jquery.scrollTo.js"></script>
        <script src="js/mylibs/jquery.ui.touch-punch.js"></script>
        <script src="js/mylibs/jquery.ui.multiaccordion.js"></script>
        <script src="js/mylibs/number-functions.js"></script>
        <!-- Forms -->
        <script src="js/mylibs/forms/jquery.autosize.js"></script>
        <script src="js/mylibs/forms/jquery.checkbox.js"></script>
        <script src="js/mylibs/forms/jquery.chosen.js"></script>
        <script src="js/mylibs/forms/jquery.cleditor.js"></script>
        <script src="js/mylibs/forms/jquery.colorpicker.js"></script>
        <script src="js/mylibs/forms/jquery.ellipsis.js"></script>
        <script src="js/mylibs/forms/jquery.fileinput.js"></script>
        <script src="js/mylibs/forms/jquery.fullcalendar.js"></script>
        <script src="js/mylibs/forms/jquery.maskedinput.js"></script>
        <script src="js/mylibs/forms/jquery.mousewheel.js"></script>
        <script src="js/mylibs/forms/jquery.placeholder.js"></script>
        <script src="js/mylibs/forms/jquery.pwdmeter.js"></script>
        <script src="js/mylibs/forms/jquery.ui.datetimepicker.js"></script>
        <script src="js/mylibs/forms/jquery.ui.spinner.js"></script>
        <script src="js/mylibs/forms/jquery.validate.js"></script>
        <script src="js/mylibs/forms/uploader/plupload.js"></script>
        <script src="js/mylibs/forms/uploader/plupload.html5.js"></script>
        <script src="js/mylibs/forms/uploader/plupload.html4.js"></script>
        <script src="js/mylibs/forms/uploader/plupload.flash.js"></script>
        <script src="js/mylibs/forms/uploader/jquery.plupload.queue/jquery.plupload.queue.js"></script>
        <!-- Charts -->
        <script src="js/mylibs/charts/jquery.flot.js"></script>
        <script src="js/mylibs/charts/jquery.flot.orderBars.js"></script>
        <script src="js/mylibs/charts/jquery.flot.pie.js"></script>
        <script src="js/mylibs/charts/jquery.flot.resize.js"></script>
        <!-- Explorer -->
        <script src="js/mylibs/explorer/jquery.elfinder.js"></script>
        <!-- Fullstats -->
        <script src="js/mylibs/fullstats/jquery.css-transform.js"></script>
        <script src="js/mylibs/fullstats/jquery.animate-css-rotate-scale.js"></script>
        <script src="js/mylibs/fullstats/jquery.sparkline.js"></script>
        <!-- Syntax Highlighter -->
        <script src="js/mylibs/syntaxhighlighter/shCore.js"></script>
        <script src="js/mylibs/syntaxhighlighter/shAutoloader.js"></script>
        <!-- Dynamic Tables -->
        <script src="js/mylibs/dynamic-tables/jquery.dataTables.js"></script>
        <script src="js/mylibs/dynamic-tables/jquery.dataTables.tableTools.zeroClipboard.js"></script>
        <script src="js/mylibs/dynamic-tables/jquery.dataTables.tableTools.js"></script>
        <!-- Gallery -->
        <script src="js/mylibs/gallery/jquery.fancybox.js"></script>
        <!-- Tooltips -->
        <script src="js/mylibs/tooltips/jquery.tipsy.js"></script>
        <!-- Do not touch! -->
        <script src="js/mango.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/script.js"></script>
        <!-- Your custom JS goes here -->
        <script src="js/app.js"></script>
        <!-- end scripts -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <br>
    <meta charset="utf-8">


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta name="description" content="Mango is a slick and responsive Admin Template build with modern techniques like HTML5 and CSS3 to be used for backend solutions of any size.">
    <meta name="author" content="Simon Stamm &amp; Markus Siemens">
    <!-- Mobile viewport optimized: h5bp.com/viewport -->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <!-- iPhone: Don't render numbers as call links -->
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon" href="favicon.ico">

    <!-- The Styles --> <br>
    <meta charset="utf-8">

    <!-- Use the .htaccess and remove these lines to avoid edge case issues.
           More info: h5bp.com/b/378 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta name="description" content="Mango is a slick and responsive Admin Template build with modern techniques like HTML5 and CSS3 to be used for backend solutions of any size.">
    <meta name="author" content="Simon Stamm &amp; Markus Siemens">
    <!-- Mobile viewport optimized: h5bp.com/viewport -->
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <!-- iPhone: Don't render numbers as call links -->
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory: mathiasbynens.be/notes/touch-icons -->

    <script type="text/javascript">
            $().ready(function() {
        <c:forEach var="msj" items="${proceso}">
            <c:if test="${msj.getRta() == 'ERR'}">
                alert('${msj.getDet_rta()}');
            </c:if>
        </c:forEach>
            });
    </script>

</head>
<body class="login"> 
    <!-- The loading box -->
    <div id="loading-overlay"></div>
    <div id="loading"> <span>Loading...</span> </div> 

    <!-- The header containing the logo -->
    <header class="container_12">
        <div class="container">
            <a href="registrarCuentaCliente.htm">
                <img src="img/logo-light.png" alt="Mango" height="67" width="210">
            </a>
            <a class="phone-title" href="registrarCuentaCliente.htm">
                <img src="img/logo-mobile.png" alt="Mango" height="22" width="70">
            </a>
        </div>     
    </header>

    <section id="login" class="container_12 clearfix">
        <form action="index.htm" method="post" class="box validate" id="index" name="index">
            <div class="header">
                <h2><span class="icon icon-lock"></span>Login</h2>
            </div>
            <div class="content">
                <!-- Login messages -->
                <div class="login-messages">
                    <div class="message welcome">Bienvenidos - UNSCH</div>
                    <div class="message failure">Ingrese usuario y clave.</div>
                </div>
                <!-- The form -->
                <div class="form-box">
                    <div class="row"> <label for="login_name"> <strong>Usuario</strong>
                            <small>Or email</small> </label>
                        <div> <input tabindex="1" class="required noerror" name="txtnombreusuario"

                                     id="txtnombreusuario" type="text"> </div>
                    </div>
                    <div class="row"> <label for="login_pw"> <strong>Password</strong>
                            <small><a href="javascript:void(0);" id="">Forgot it?</a></small>
                        </label>
                        <div> <input tabindex="2" class="required noerror" name="txtclaveusuario"

                                     id="txtclaveusuario" type="password"> </div>
                    </div>
                </div>
                <!-- End of .form-box --> </div>
            <!-- End of .content -->
            <div class="actions">
                <div class="left">
                    <div class="rememberme"> <input tabindex="4" name="login_remember"

                                                    id="login_remember" checked="checked" type="checkbox">
                        <label for="login_remember">Administrador?Cliente</label> </div>
                </div>
                <div class="right"> 
                    <input tabindex="3" value="Login"  type="submit"  /> 
                </div>
            </div>
            <!-- End of .actions --> </form>
        <!-- End of form --> 
    </section>
    <!-- Spawn $$.loaded -->
    <script>
        $$.loaded();
    </script>

</body>
</html>

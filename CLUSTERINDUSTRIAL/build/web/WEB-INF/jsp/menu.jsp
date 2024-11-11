<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Consider adding a manifest.appcache: h5bp.com/d/Offline -->
<!--[if gt IE 8]><!--> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="utf-8" />

    <!-- Use the .htaccess and remove these lines to avoid edge case issues.
       More info: h5bp.com/b/378 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>UNIVERSIDAD NACIONAL DE SAN CRISTÓBAL DE HUAMANGA</title>
    <meta name="description" content="Mango is a slick and responsive Admin Template build with modern techniques like HTML5 and CSS3 to be used for backend solutions of any size." />
    <meta name="author" content="Simon Stamm & Markus Siemens" />

    <!-- Mobile viewport optimized: h5bp.com/viewport -->
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <!-- iPhone: Don't render numbers as call links -->
    <meta name="format-detection" content="telephone=no" />

    <link rel="shortcut icon" href="favicon.ico" />
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory: mathiasbynens.be/notes/touch-icons -->

    <!-- Layout Styles -->
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/grid.css" />
    <link rel="stylesheet" href="css/layout.css" />

    <!-- Icon Styles -->
    <link rel="stylesheet" href="css/icons.css" />
    <link rel="stylesheet" href="css/fonts/font-awesome.css" />
    <!--[if IE 8]><link rel="stylesheet" href="css/fonts/font-awesome-ie7.css"><![endif]-->

    <!-- External Styles -->
    <link rel="stylesheet" href="css/external/jquery-ui-1.8.21.custom.css" />
    <link rel="stylesheet" href="css/external/jquery.chosen.css" />
    <link rel="stylesheet" href="css/external/jquery.cleditor.css" />
    <link rel="stylesheet" href="css/external/jquery.colorpicker.css" />
    <link rel="stylesheet" href="css/external/jquery.elfinder.css" />
    <link rel="stylesheet" href="css/external/jquery.fancybox.css" />
    <link rel="stylesheet" href="css/external/jquery.jgrowl.css" />
    <link rel="stylesheet" href="css/external/jquery.plupload.queue.css" />
    <link rel="stylesheet" href="css/external/syntaxhighlighter/shCore.css" />
    <link rel="stylesheet" href="css/external/syntaxhighlighter/shThemeDefault.css" />

    <!-- Elements -->
    <link rel="stylesheet" href="css/elements.css" />
    <link rel="stylesheet" href="css/forms.css" />

    <!-- OPTIONAL: Print Stylesheet for Invoice -->
    <link rel="stylesheet" href="css/print-invoice.css" />

    <!-- Typographics -->
    <link rel="stylesheet" href="css/typographics.css" />

    <!-- Responsive Design -->
    <link rel="stylesheet" href="css/media-queries.css" />

    <!-- Bad IE Styles -->
    <link rel="stylesheet" href="css/ie-fixes.css" />

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
    <!--[if lt IE 9]><script src="js/mylibs/polyfills/selectivizr-min.js"></script><![endif]-->

    <script src="js/libs/jquery-1.7.2.min.js"></script>
    <script src="js/libs/jquery-ui-1.8.21.min.js"></script>
    <script src="js/libs/lodash.min.js"></script>

    <!-- scripts concatenated and minified via build script -->

    <!-- General Scripts -->
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

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>
<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false">  

    <!-- The lock screen -->
    <div id="lock-screen" title="Pantalla Bloqueada">

        <a href="logout.htm" class="header right button grey flat">Cerrar</a>

        <p>Debido a la inactividad de la sesión, su cuenta fue bloqueada temporalmente.</p>
        <p>Para desbloquear su cuenta, simplemente deslice el botón e introduzca su contraseña.</p>

        <div class="actions">
            <div id="slide_to_unlock">
                <img src="img/elements/slide-unlock/lock-slider.png" alt="slide me" />
                <span>deslice para desbloquear</span>
            </div>
            <form action="#" method="GET" />
            <input type="password" name="pwd" id="pwd" placeholder="Enter your password here..." autocorrect="off" autocapitalize="off" /> <input type="submit" name="send" value="Desbloquear" disabled="" /> <input type="reset" value="X" />
            </form>
        </div><!-- End of .actions -->

    </div><!-- End of lock screen -->

    <!-- The settings dialog -->
    <div id="settings" class="settings-content" data-width="450">

        <ul class="tabs center-elements">
            <li><a href="#settings-1"><img src="img/icons/packs/fugue/24x24/user-business.png" alt="" /><span>Account Settings</span></a></li>
            <li><a href="#settings-2"><img src="img/icons/packs/fugue/24x24/balloon.png" alt="" /><span>Notifications</span></a></li>
            <li><a href="#settings-3"><img src="img/icons/packs/fugue/24x24/credit-card.png" alt="" /><span>Invoicing</span></a></li>
        </ul>

        <div class="change_password">
            <form action="#" method="GET" class="validate" id="settings_password" />
            <p>
                <label for="settings-password">New Password:</label> <input type="password" id="settings-password" class="required strongpw small password meter" />
            </p>
            </form>
            <div class="actions">
                <div class="right">
                    <input form="settings_password" type="reset" value="Cancel" class="grey" />
                    <input form="settings_password" type="submit" value="OK" />
                </div>
            </div>
        </div><!-- End of .change_password -->

        <div class="content">

            <div id="settings-1">
                <form action="#" method="GET" />
                <p>
                    <label for="settings-name">Name:</label> <input type="text" id="settings-name" class="medium" />
                </p>
                <p>
                    <label for="settings-descr">Descripton:</label> <input type="text" id="settings-descr" class="medium" />
                </p>
                <p class="divider" />
                <p>
                    <label for="settings-pw">Password: </label> <input class="grey change_password_button" type="button" id="settings-pw" value="Change Password..." data-lang-changed="Password changed" />
                </p>
                </form>
            </div><!-- End of #settings-1 -->

            <div id="settings-2">
                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.
                <form action="#" method="GET" />
                <div class="spacer"></div>
                <p class="divider" />
                <div class="spacer"></div>
                <p>
                    <label for="settings-email">Email Address:</label> <input type="text" id="settings-email" class="medium" />
                </p>
                <p>
                    <label for="settings-interval">Interval: </label>
                    <select name="settings-interval" id="settings-interval" data-placeholder="Choose an Interval">
                        <option value="" />
                        <option value="Never" />Never
                        <option value="Daily" />Daily
                        <option value="Weekly" />Weekly
                        <option value="Monthly" />Monthly
                        <option value="Yearly" />Yearly
                    </select>
                </p>
                </form>
            </div><!-- End of #settings-2 -->

            <div id="settings-3">
                <form action="#" method="GET" />
                <p>
                    <label for="settings-card-number">Card number:</label> <input type="text" id="settings-card-number" class="medium" />
                </p>
                <p>
                    <label for="settings-cvv">CVV:</label> <input type="text" id="settings-cvv" class="medium" />
                </p>
                <p>
                    <label for="settings-expiration">Expiration: </label>
                    <select sname="settings-expiration" id="settings-expiration" data-placeholder="Choose an Expiration">
                        <option value="" />
                        <option value="2012" />2012
                        <option value="2013" />2013
                        <option value="2014" />2014
                        <option value="2015" />2015
                    </select>
                </p>
                </form>
            </div><!-- End of #settings-3 -->

        </div><!-- End of .content -->

        <div class="actions">
            <div class="left">
                <button class="grey cancel">Cancel</button>
            </div>
            <div class="right">
                <button class="save">Save</button>
                <button class="hide saving" disabled="">Saving...</button>
            </div>
        </div><!-- End of .actions -->

    </div><!-- End of settings dialog -->

    <!-- Add Client Example Dialog -->
    <div style="display: none;" id="dialog_add_client" title="Add Client Example Dialog">
        <form action="" class="full validate" />
        <div class="row">
            <label for="d2_username">
                <strong>Username</strong>
            </label>
            <div>
                <input class="required" type="text" name="d2_username" id="d2_username" />
            </div>
        </div>
        <div class="row">
            <label for="d2_email">
                <strong>Email Address</strong>
            </label>
            <div>
                <input class="required" type="text" name="d2_email" id="d2_email" />
            </div>
        </div>
        <div class="row">
            <label for="d2_role">
                <strong>Role</strong>
            </label>
            <div>
                <select style="padding-bottom: 10px" name="d2_role" id="d2_role" class="search required" data-placeholder="Choose a Role">
                    <option value="" />
                    <option value="Applicant" />Applicant 
                    <option value="Member" />Member 
                    <option value="Moderator" />Moderator 
                    <option value="Administrator" />Administrator 
                </select>
            </div>
        </div>
    </form>
    <div class="actions">
        <div class="left">
            <button class="grey cancel">Cancel</button>
        </div>
        <div class="right">
            <button class="submit">Add User</button>
        </div>
    </div>
</div><!-- End if #dialog_add_client -->

<script>
        $$.ready(function() {
            $("#dialog_add_client").dialog({
                autoOpen: false,
                modal: true,
                width: 400,
                open: function() {
                    $(this).parent().css('overflow', 'visible');
                    $$.utils.forms.resize();
                }
            }).find('button.submit').click(function() {
                var $el = $(this).parents('.ui-dialog-content');
                if ($el.validate().form()) {
                    $el.find('form')[0].reset();
                    $el.dialog('close');
                }
            }).end().find('button.cancel').click(function() {
                var $el = $(this).parents('.ui-dialog-content');
                $el.find('form')[0].reset();
                $el.dialog('close');
                ;
            });

            $(".open-add-client-dialog").click(function() {
                $("#dialog_add_client").dialog("open");
                return false;
            });
        });
</script>
<!--  End of Add Client Example Dialog -->

<!-- Message Dialog -->
<div style="display: none;" id="dialog_message" title="Conversation: John Doe">
    <div class="spacer"></div>
    <div class="messages full chat">

        <div class="msg reply">
            <img src="img/icons/packs/iconsweets2/25x25/user-2.png" />
            <div class="content">
                <h3><a href="pages_profile.html">John Doe</a> <span>says:</span><small>3 hours ago</small></h3>
                <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore
                    et dolore magna aliquyam erat, sed diam voluptua.</p>
            </div>
        </div>

        <div class="msg">
            <img src="img/icons/packs/iconsweets2/25x25/user-2.png" />
            <div class="content">
                <h3><a href="pages_profile.html">Peter Doe</a> <span>says:</span><small>5 hours ago</small></h3>
                <p>At vero eos et accusam et justo duo dolores et ea rebum.
                    Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
            </div>
        </div>

    </div><!-- End of .messages -->

    <div class="actions">
        <div class="left">
            <input style="width: 330px;" type="text" name="d3_message" id="d3_message" placeholder="Type your message..." />
        </div>
        <div class="right">
            <button>Send</button>
            <button class="grey">Cancel</button>
        </div>
    </div><!-- End of .actions -->

</div><!-- End of #dialog_message -->

<script>
    $$.ready(function() {
        $("#dialog_message").dialog({
            autoOpen: false,
            width: 500,
            modal: true
        }).find('button').click(function() {
            $(this).parents('.ui-dialog-content').dialog('close');
        });

        $(".open-message-dialog").click(function() {
            $("#dialog_message").dialog("open");
            return false;
        });
    });
</script>
<!-- End of Message Dialog -->

<!-- The toolbar at the top -->
<section id="toolbar">
    <div class="container_12">

        <!-- Right side -->
        <div class="right">
            <ul>           

                <li class="space"></li>

                <li><a href="javascript:void(0);" id="btn-lock"><span>--:--</span>Bloquear Pantalla</a></li>

                <li class="red"><a href="logout.htm">Cerrar</a></li>

            </ul>
        </div><!-- End of .right -->

        <!-- Phone only items -->
        <div class="phone">

            <!-- User Link -->
            <li><a href="pages_profile.html"><span class="icon icon-user"></span></a></li>
            <!-- Navigation -->
            <li><a class="navigation" href="#"><span class="icon icon-list"></span></a></li>

        </div><!-- End of phone items -->

    </div><!-- End of .container_12 -->
</section><!-- End of #toolbar -->

<!-- The header containing the logo -->
<header class="container_12">


</header><!-- End of header -->

<!-- The container of the sidebar and content box -->
<div role="main" id="main" class="container_12 clearfix">

    <!-- The blue toolbar stripe -->
    <section class="toolbar">
        <div class="user">
            <div class="avatar">
                <img src="img/layout/content/toolbar/user/avatar.png" />
                <span>3</span>
            </div>        
            <span>${sesionclient}</span>
            <ul>
                <li><a href="javascript:$$.settings();">Herramientas</a></li>
                <li><a href="#">Perfil</a></li>
                <li class="line"></li>
                <li><a href="logout.htm">Cerrar</a></li>
            </ul>
        </div>
        <ul class="shortcuts">

            <li>
                <a href="javascript:void(0);"><span class="icon i24_user-business"></span></a>
                <!-- Possible sizes: small/medium/large -->
                <div class="small">
                    <h3>Create a User</h3>

                    <!-- Button bar -->
                    <button class="button flat left grey" onclick="$(this).parent().fadeToggle($$.config.fxSpeed).parent().removeClass('active')">Close</button>
                    <button class="button flat right" onclick="$(this).parent().fadeToggle($$.config.fxSpeed).parent().removeClass('active')">Create</button>

                    <div class="content">
                        <form class="full grid" />
                        <div class="row no-bg">
                            <p class="_100 small">
                                <label for="p1_username">Username</label>
                                <input type="text" name="p1_username" id="p1_username" />
                            </p>
                        </div>
                        <div class="row no-bg">
                            <p class="_50 small">
                                <label for="p1_firstname">Firstname</label>
                                <input type="text" name="p1_firstname" id="p1_firstname" />
                            </p>
                            <p class="_50 small">
                                <label for="p1_lastname">Lastname</label>
                                <input type="text" name="p1_lastname" id="p1_lastname" />
                            </p>
                        </div>
                        </form>
                    </div>
                </div><!-- End of popup -->
            </li>

            <li>
                <a href="javascript:void(0);"><span class="icon i24_inbox-document"></span></a>
                <!-- Possible sizes: small/medium/large -->
                <div class="small">
                    <h3>Write a Message</h3>

                    <!-- Button bar -->
                    <button class="button flat left grey" onclick="$(this).parent().fadeToggle($$.config.fxSpeed).parent().removeClass('active')">Close</button>
                    <button class="button flat right" onclick="$(this).parent().fadeToggle($$.config.fxSpeed).parent().removeClass('active')">Send</button>

                    <div class="content">
                        <form class="full grid" />
                        <div class="row no-bg">
                            <p class="_100 small">
                                <input type="text" name="p2_recipient" id="p2_recipient" placeholder="Recipient" />
                            </p>
                            <p class="_100 small">
                                <input type="text" name="p2_subject" id="p2_subject" placeholder="Subject" />
                            </p>
                            <p class="_100 small">
                                <textarea rows="5" cols="30" name="p2_message" id="p2_message" placeholder="Message"></textarea>
                            </p>
                        </div>
                        </form>
                    </div>
                </div><!-- End of popup -->
            </li>

            <li>
                <a href="javascript:void(0);"><span class="icon i24_application-blue"></span></a>
                <!-- Possible sizes: small/medium/large -->
                <div class="small">
                    <h3>Information</h3>

                    <!-- Button bar -->
                    <button class="button flat left grey" onclick="$(this).parent().fadeToggle($$.config.fxSpeed).parent().removeClass('active')">Close</button>

                    <div class="content">
                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</p>
                    </div>
                </div><!-- End of popup -->
            </li>

        </ul><!-- End of .shortcuts -->

        <input type="search" data-source="extras/search.php" placeholder="Search..." autocomplete="off" class="tooltip" title="e.g. Peach" data-gravity="s" />
    </section><!-- End of .toolbar-->

    <!-- The sidebar -->
    <aside>
        <div class="top">

            <!-- Navigation -->
            <nav><ul class="collapsible accordion">
                    <li class="current"><a href="logout.htm"><img src="img/icons/packs/fugue/16x16/dashboard.png" alt="" height="16" width="16" />San Cristobal</a></li>


                    <li>
                        <a href="javascript:void(0);"><img src="img/icons/packs/fugue/16x16/application-form.png" alt="" height="16" width="16" />Producto</a>
                        <ul>

                            <li>
                                <a onclick="ref('listaProducto.htm');" style="cursor: pointer">
                                    <span class="icon icon-list-alt"></span>Listar Producto
                                </a>
                            </li>
                            <li>
                                <a onclick="ref('listaInventario.htm');" style="cursor: pointer">
                                    <span class="icon icon-list-alt"></span>Listar Inventario
                                </a>
                            </li>


                        </ul>
                    </li>

                    <li>
                        <a href="javascript:void(0);"><img src="img/icons/packs/fugue/16x16/chart.png" alt="" height="16" width="16" />Socio</a>
                        <ul>                                              
                            <li>
                                <a onclick="ref('listaSocio.htm');" style="cursor: pointer">
                                    <span class="icon icon-bar-chart"></span>Listar Socio
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="javascript:void(0);"><img src="img/icons/packs/fugue/16x16/table.png" alt="" height="16" width="16" />Estadistica</a>
                        <ul>
                            <li>
                                <a onclick="ref('prueba.htm');" style="cursor: pointer">
                                    <span class="icon icon-check-empty"></span>Ventas por Cluster
                                </a>
                            </li>
                            <li>
                                <a onclick="ref('listaCliente.htm');" style="cursor: pointer">
                                    <span class="icon icon-table"></span>Lista de Cliente
                                </a>
                            </li>
                            <li>
                                <a onclick="ref('viewGraficaAlmacenProducto.htm');" style="cursor: pointer">
                                    <span class="icon icon-fullscreen"></span>Producto por Almacen
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="javascript:void(0);"><img src="img/icons/packs/fugue/16x16/document-horizontal.png" alt="" height="16" width="16" />Compra</a>
                        <ul>
                            <li>
                                <a onclick="ref('listaAlmacenCluster.htm');" style="cursor: pointer">Orden Compra
                                </a>
                            </li>
                            <li>
                                <a onclick="ref('listaOrdenCompra.htm');" style="cursor: pointer">Lista Orden
                                </a>
                            </li>                      
                            <li>
                                <a onclick="ref('listaCertificado.htm');" style="cursor: pointer">Lista Certificado
                                </a>
                            </li>
                            <li>
                                <a onclick="ref('registrarMovimiento.htm');" style="cursor: pointer">Pago Electronico
                                </a>
                            </li>

                        </ul>
                    </li>

                    <li>
                        <a href="javascript:void(0);"><img src="img/icons/packs/fugue/16x16/document-horizontal.png" alt="" height="16" width="16" />Adicional</a>
                        <ul>

                            <li>
                                <a onclick="ref('listaSugerencia.htm');" style="cursor: pointer">Lista Sugerencia
                                </a>
                            </li>                       

                            <li>
                                <a onclick="ref('registrarSugerencia.htm');" style="cursor: pointer">Sugerencia
                                </a>
                            </li>
                            <li><a href="#">Ranking Sugerencia</a></li>
                        </ul>
                    </li>

                </ul></nav><!-- End of nav -->				
        </div><!-- End of .top -->


    </aside><!-- End of sidebar -->

    <!-- Here goes the content. -->
    <section id="content" class="container_12 clearfix" data-sort="true">      
        <div id="mydiv">
            <iframe id="frame" frameborder="0" src="" width="100%" height="750">
            </iframe>
        </div>      
    </section><!-- End of #content -->

</div><!-- End of #main -->

<!-- The footer -->
<footer class="container_12">
    <ul class="grid_6">
        <li><a href="#">San Cristobal</a></li>
        <li><a href="#">Oportunidad Laboral</a></li>
        <li><a href="#">Cristobalin</a></li>
    </ul>

    <span class="grid_6">
        Copyright &copy; 2014 Claudio Arango Palomino - Ingenieria de Sistemas - UNSCH
    </span>
</footer><!-- End of footer -->

<!-- Spawn $$.loaded -->
<script>
    $$.loaded();
</script>

<script type="text/javascript">
    function ref(pag) {
        document.getElementById("frame").src = pag;
    }
</script>

</body>
</html>


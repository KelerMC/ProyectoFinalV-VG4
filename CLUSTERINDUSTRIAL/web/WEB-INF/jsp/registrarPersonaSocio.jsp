<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html class="no-js" lang="en"> <!--<![endif]-->
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


        <!-- Load Webfont loader -->
        <script type="text/javascript">
            window.WebFontConfig = {
                google: {families: ['PT Sans:400,700']},
                active: function() {
                    $(window).trigger('fontsloaded');
                }
            };</script>


        <!-- Essential polyfills -->
        <script src="js/mylibs/polyfills/modernizr-2.6.1.min.js"></script>
        <script src="js/mylibs/polyfills/respond.js"></script>
        <script src="js/mylibs/polyfills/matchmedia.js"></script>
        <!--[if lt IE 9]><script src="js/mylibs/polyfills/selectivizr-min.js"></script><![endif]-->

        <script src="js/libs/jquery-1.7.2.min.js"></script>
        <script src="js/libs/jquery-ui-1.8.21.min.js"></script>
        <script src="js/libs/lodash.min.js"></script>

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

        <!-- Explorer -->
        <script src="js/mylibs/explorer/jquery.elfinder.js"></script>

        <!-- Fullstats -->
        <script src="js/mylibs/fullstats/jquery.css-transform.js"></script>
        <script src="js/mylibs/fullstats/jquery.animate-css-rotate-scale.js"></script>
        <script src="js/mylibs/fullstats/jquery.sparkline.js"></script>

        <!-- Syntax Highlighter -->
        <script src="js/mylibs/syntaxhighlighter/shCore.js"></script>
        <script src="js/mylibs/syntaxhighlighter/shAutoloader.js"></script>

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

    <body>
        <!-- The loading box -->
        <div id="loading-overlay"></div>
        <div id="loading">
            <span>Loading...</span>
        </div>
        <!-- End of loading box -->

        <div role="main" id="main" class="container_12 clearfix">

            <section id="content" class="container_12 clearfix" data-sort="true">  
                ﻿			
                <form action=""  class="grid_12" id="signupform" name="signupform">
                    <legend>REGISTRO DE PERSONA SOCIO POR CLUSTER</legend>

                    <div class="row">
                        <label for="f2_select2">
                            <strong>UBIGEO</strong>                          
                        </label>
                        <div>
                            <select name="txtidubigeo" id="txtidubigeo" class="search" data-placeholder="Seleccione ubigeo">
                                <c:forEach var="lisUbigeo" items="${listaUbigeo}">
                                    <option value="<c:out value="${lisUbigeo.ubigeoid}"></c:out>"><c:out value="${lisUbigeo.descripcion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="f2_select1">
                            <strong>NACIONALIDAD</strong>                           
                        </label>
                        <div>
                            <select name="txtnacionalidadid" id="txtnacionalidadid" class="search" data-placeholder="Seleccione nacionalidad">
                                <c:forEach var="lisNacionalidad" items="${listaNacionalidad}">
                                    <option value="<c:out value="${lisNacionalidad.nacionalidadid}"></c:out>"><c:out value="${lisNacionalidad.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>NOMBRE</strong>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtnombrepersona" id="txtnombrepersona" />
                        </div>
                    </div>                 

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>APELLIDO PATERNO</strong>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtapepaterno" id="txtapepaterno" />
                        </div>
                    </div>      

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>APELLIDO MATERNO</strong>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtapmaterno" id="txtapmaterno" />
                        </div>
                    </div>   

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>TIPO DOCUMENTO IDENTIDAD</strong>
                        </label>
                        <div>
                            <select name="txtdocumentoidentidadid" id="txtdocumentoidentidadid" class="search" data-placeholder="Seleccione tipo documento">
                                <c:forEach var="lisDocumento" items="${listaDocumento}">
                                    <option value="<c:out value="${lisDocumento.tablaid}"></c:out>"><c:out value="${lisDocumento.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>   

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>NUMERO DOCUMENTO</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtnumerodocumento" id="txtnumerodocumento" />
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>DIRECCION</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtdireccion" id="txtdireccion" />
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>REFERENCIA DIRECCION</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtreferenciadireccion" id="txtreferenciadireccion" />
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>EMAIL PERSONA</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtemailpersonal" id="txtemailpersonal" />
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>TIPO TELEFONO</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <select name="txtidtipotelefono" id="txtidtipotelefono" class="search" data-placeholder="Seleccione tipo telefono">
                                <c:forEach var="lisTelefono" items="${listaTipoTelefono}">
                                    <option value="<c:out value="${lisTelefono.tablaid}"></c:out>"><c:out value="${lisTelefono.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>NUMERO TELEFONO</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <input class="required" type="text" name="txtnumerotelefono" id="txtnumerotelefono" />
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>FECHA NACIMIENTO</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <input class="required" type="date" name="txtfechanacimiento" id="txtfechanacimiento" />
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>TIPO PERSONA</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <select name="txttipopersonaid" id="txttipopersonaid" class="search" data-placeholder="Seleccione tipo persona">
                                <c:forEach var="lisTipoPersona" items="${listaTipoPersona}">
                                    <option value="<c:out value="${lisTipoPersona.tablaid}"></c:out>"><c:out value="${lisTipoPersona.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>  

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>CLUSTER</strong>
                            <small>e.g. solo numeros</small>
                        </label>
                        <div>
                            <select name="txtclusteresid" id="txtclusteresid" class="search" data-placeholder="Seleccione cluster">
                                <c:forEach var="lisCluster" items="${listaCluster}">
                                    <option value="<c:out value="${lisCluster.clusteresid}"></c:out>"><c:out value="${lisCluster.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>  

                    <div class="actions">
                        <div class="left">
                            <input type="reset" value="Nuevo" />
                        </div>
                        <div class="right">
                            <input type="button" id="btnGuardar" name="btnGuardar" value="Guardar"/>                           
                        </div>
                    </div><!-- End of .actions -->



                </form>
            </section>
        </div><!-- End of #main -->
        <script>
            $$.loaded();
        </script>

        <script type="text/javascript">
            $$.ready(function() {
                $("#btnGuardar").click(function() {
                    var txtidubigeo = $('#txtidubigeo').val();
                    var txtnacionalidadid = $('#txtnacionalidadid').val();
                    var txtnombrepersona = $('#txtnombrepersona').val();
                    var txtapepaterno = $('#txtapepaterno').val();
                    var txtapmaterno = $('#txtapmaterno').val();
                    var txtdocumentoidentidadid = $('#txtdocumentoidentidadid').val();
                    var txtnumerodocumento = $('#txtnumerodocumento').val();
                    var txtdireccion = $('#txtdireccion').val();
                    var txtreferenciadireccion = $('#txtreferenciadireccion').val();
                    var txtemailpersonal = $('#txtemailpersonal').val();
                    var txtidtipotelefono = $('#txtidtipotelefono').val();
                    var txtnumerotelefono = $('#txtnumerotelefono').val();
                    var txtfechanacimiento = $('#txtfechanacimiento').val();
                    var txttipopersonaid = $('#txttipopersonaid').val();
                    var txtclusteresid = $('#txtclusteresid').val();
                    var object = {
                        txtidubigeo: txtidubigeo, txtnacionalidadid: txtnacionalidadid, txtnombrepersona: txtnombrepersona,
                        txtapepaterno: txtapepaterno, txtapmaterno: txtapmaterno, txtdocumentoidentidadid: txtdocumentoidentidadid,
                        txtnumerodocumento: txtnumerodocumento, txtdireccion: txtdireccion, txtreferenciadireccion: txtreferenciadireccion,
                        txtemailpersonal: txtemailpersonal, txtidtipotelefono: txtidtipotelefono, txtnumerotelefono: txtnumerotelefono,
                        txtfechanacimiento: txtfechanacimiento, txttipopersonaid: txttipopersonaid, txtclusteresid: txtclusteresid
                    };

                    $.ajax({
                        type: "get",
                        url: "registarPersonaSocio.htm",
                        data: object,
                        dataType: "json",
                        success: function(response) {
                            var i;
                            for (i = 0; i < response.length; i++) {
                                alert(response[i].rta + response[i].det_rta);
                            }
                            window.close();
                            $("#signupform")[0].reset();
                        },
                        error: function(e) {
                            alert('Error General .......: ' + e.toString());
                        }
                    });
                });
            });
        </script>
    </body>
</html>
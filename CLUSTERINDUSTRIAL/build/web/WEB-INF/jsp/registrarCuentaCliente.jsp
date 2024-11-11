<%-- 
    Document   : solicitar_cuenta
    Created on : 22-dic-2012, 15:04:09
    Author     : Arango
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <div role="main" id="main" class="container_12 clearfix">
            <section id="content" class="container_12 clearfix" data-sort="true">  
                <form action=""  class="grid_12" id="signupform" name="signupform">

                    <legend>REGISTRO DE CLIENTE</legend>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong> NACIONALIDAD  </strong>
                        </label>
                        <div>
                            <select id="txtnacionalidadid" name="txtnacionalidadid" class="search" data-placeholder="Seleccione tipo movimiento">
                                <c:forEach var="listCatPubli" items="${bObjectList}">
                                    <option value="<c:out value="${listCatPubli.nacionalidadid}"></c:out>"><c:out value="${listCatPubli.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>UBIGEO  </strong>
                        </label>
                        <div>
                            <select id="txtidubigeo" name="idubigeo" class="search" data-placeholder="Seleccione tipo movimiento">
                                <c:forEach var="listCatPubli" items="${listaUbigeo}">
                                    <option value="<c:out value="${listCatPubli.ubigeoid}"></c:out>"><c:out value="${listCatPubli.descripcion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>  NOMBRES  </strong>
                        </label>
                        <div>
                            <input type="text" id="txtnombrepersona" name="txtnombrepersona" value="" />  
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>   APELLIDO PATERNO  </strong>
                        </label>
                        <div> 
                            <input type="text" id="txtapepaterno" name="txtapepaterno" value="" />
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>       APELLIDO MATERNO  </strong>
                        </label>
                        <div>
                            <input type="text" id="txtapmaterno" name="txtapmaterno" value="" />
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>    DOCUMENTO IDENTIDAD  </strong>
                        </label>
                        <div>
                            <select id="txtdocumentoidentidadid" name="txtdocumentoidentidadid" class="search" data-placeholder="Seleccione tipo movimiento">
                                <c:forEach var="listCatPubli" items="${listaDocumento}">
                                    <option value="<c:out value="${listCatPubli.tablaid}"></c:out>"><c:out value="${listCatPubli.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong> NUMERO DOCUMENTO  </strong>
                        </label>
                        <div> 
                            <input type="text" id="txtnumerodocumento" name="txtnumerodocumento" value="" />  
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>     DIRECCION  </strong>
                        </label>
                        <div>  
                            <input type="text" id="txtdireccion" name="txtdireccion" value="" /> 
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>  REFRENCIA DIRECCION  </strong>
                        </label>
                        <div>
                            <input type="text" id="txtreferenciadireccion" name="txtreferenciadireccion" value="" />  
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>  EMAIL  </strong>
                        </label>
                        <div>   
                            <input type="text" id="txtemailpersonal" name="txtemailpersonal" value="" />   
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>  TIPO TELEFONO  </strong>
                        </label>
                        <div>
                            <select id="txtidtipotelefono" name="txtidtipotelefono" class="search" data-placeholder="Seleccione tipo movimiento">
                                <c:forEach var="listCatPubli" items="${listaTipoTelefono}">
                                    <option value="<c:out value="${listCatPubli.tablaid}"></c:out>"><c:out value="${listCatPubli.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>   NUMERO TELEFONO  </strong>
                        </label>
                        <div> 
                            <input type="text" id="txtnumerotelefono" name="txtnumerotelefono" value="" />   
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong> FECHA NACIMIENTO  </strong>
                        </label>
                        <div> 
                            <input type="date" name="txtfechanacimiento" value="" id="txtfechanacimiento"/>   
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>   TIPO PERSONA  </strong>
                        </label>
                        <div>
                            <select id="txttipopersonaid" name="txttipopersonaid" class="search" data-placeholder="Seleccione tipo movimiento">
                                <c:forEach var="listCatPubli" items="${listaTipoPersona}">
                                    <option value="<c:out value="${listCatPubli.tablaid}"></c:out>"><c:out value="${listCatPubli.denominacion}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong> CODIGO POSTAL  </strong>
                        </label>
                        <div>  
                            <input type="text" id="txtcodigopostal" name="txtcodigopostal" value="" />
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>    REGION  </strong>
                        </label>
                        <div>  
                            <input type="text" id="txtregion" name="txtregion" value="" />  
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>  CUENTA USUARIO  </strong>
                        </label>
                        <div>  
                            <input type="text" id="txtnombrecliente" name="txtnombrecliente" value="" /> 
                        </div>
                    </div>

                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>   CLAVE USUARIO  </strong>
                        </label>
                        <div> 
                            <input type="password" id="txtclavecliente" name="txtclavecliente" value="" />   
                        </div>
                    </div>
                    <div class="actions">
                        <div class="left">
                            <input type="reset" value="Nuevo" />
                        </div>
                        <div class="right">
                            <input type="button" id="btnGuardar" name="btnGuardar" value="Guardar"/>                           
                        </div>                   
                    </div>

                </form>
            </section>
        </div>

        <script>
            $$.loaded();
        </script>


        <script type="text/javascript">
            $(document).ready(function() {
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
                    var txtcodigopostal = $('#txtcodigopostal').val();
                    var txtregion = $('#txtregion').val();
                    var txtnombrecliente = $('#txtnombrecliente').val();
                    var txtclavecliente = $('#txtclavecliente').val();

                    var object = {
                        txtidubigeo: txtidubigeo, txtnacionalidadid: txtnacionalidadid,
                        txtnombrepersona: txtnombrepersona, txtapepaterno: txtapepaterno,
                        txtapmaterno: txtapmaterno, txtdocumentoidentidadid: txtdocumentoidentidadid,
                        txtnumerodocumento: txtnumerodocumento, txtdireccion: txtdireccion,
                        txtreferenciadireccion: txtreferenciadireccion, txtemailpersonal: txtemailpersonal,
                        txtidtipotelefono: txtidtipotelefono,
                        txtnumerotelefono: txtnumerotelefono, txtfechanacimiento: txtfechanacimiento,
                        txttipopersonaid: txttipopersonaid, txtcodigopostal: txtcodigopostal,
                        txtregion: txtregion, txtnombrecliente: txtnombrecliente,
                        txtclavecliente: txtclavecliente
                    };
                    $.ajax({
                        type: "get",
                        url: "RegitrarPersonaCliente.htm",
                        data: object,
                        dataType: "json",
                        success: function(response) {
                            var i;
                            for (i = 0; i < response.length; i++) {
                                alert(response[i].rta + response[i].det_rta);
                            }
                            $(":text").each(function() {
                                $($(this)).val('');
                            });
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

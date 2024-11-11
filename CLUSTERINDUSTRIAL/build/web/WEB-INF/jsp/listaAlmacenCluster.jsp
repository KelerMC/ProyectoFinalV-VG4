<%-- 
    Document   : listaAlmacenCluster
    Created on : 21-feb-2014, 23:44:45
    Author     : ARANGO
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />

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

        <!-- jqgrid -->
        <link rel="stylesheet" href="jqgrid/jqgrid/ui.jqgrid.css"/>     
        <script src="jqgrid/script/grid.locale-es.js" type="text/javascript"></script>
        <script src="jqgrid/script/jquery.jqGrid.min.js" type="text/javascript"></script>

    </head>
    <body onload="getData();">
        <div role="main" id="main" class="container_12 clearfix">
            <section id="content" class="container_12 clearfix" data-sort="true">
                <form action="" class="grid_12">

                    <legend>CATALOGO DE PRODUCTO</legend>   
                    <div>
                        <!-- Invoice Header -->

                        <table id="list2"></table> 
                        <div id="pager2"></div> 
                        <br />
                        <!-- Invoice Detail -->

                        <table id="list10_d"></table>
                        <div id="pager10_d"></div>

                        <button id="ms1" name="ms1">Probar</button>
                    </div>
                </form>

                <form action=""  class="grid_12" id="signupform" name="signupform">

                    <legend>REGISTRO ORDEN DE COMPRA</legend>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>NRO</strong>
                        </label>
                        <div>
                            <input type="text" disabled="" name="txtinventarioid" id="txtinventarioid" />
                        </div>
                    </div>
                    <div class="row">
                        <label for="v1_normal_input">
                            <strong>CANTIDAD</strong>
                        </label>
                        <div>
                            <input type="text" id="txtcantidad" name="txtcantidad" value="" />  
                        </div>
                    </div>            

                    <div class="row not-on-phone">
                        <label for="f1_wysiwyg">
                            <strong>OBSERVACION/CONSULTA</strong>
                            <small>Sugerencias</small>
                        </label>
                        <div>
                            <textarea class="editor" name="txtobservacion" id="txtobservacion"></textarea>
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
            function getData() {
                $(document).ready(function() {



                    $("#list2").jqGrid('GridUnload');
                    $("#list2").jqGrid({
                        url: 'recuperarAlmacenCluster.htm',
                        height: 'auto',
                        datatype: "json",
                        colNames:
                                [
                                    'NRO', 'CLUSTER', 'ALMACEN', 'ESTADO'
                                ],
                        colModel: [
                            {name: 'almacenid', index: 'almacenid', width: 50, sortable: false, align: 'left'},
                            {name: 'denominacionC', index: 'denominacionC', width: 350, sortable: false, align: 'left'},
                            {name: 'denominacionA', index: 'denominacionA', width: 350, sortable: false, align: 'left'},
                            {name: 'estadoalmacen', index: 'estadoalmacen', width: 100, sortable: false, align: 'center', formatter: activoFormatter}

                        ],
                        rowNum: 10,
                        rowList: [10, 20, 30],
                        pager: '#pager2',
                        sortname: 'almacenid',
                        loadonce: true,
                        viewrecords: true,
                        sortorder: "desc",
                        multiselect: false,
                        caption: "ALMACEN POR CLUSTER",
                        onSelectRow: function(id) {
                            var ids = $('#list2').getCell(id, "almacenid");
                            if (ids == null) {
                                ids = 0;
                                if ($("#list10_d").jqGrid('getGridParam', 'records') > 0) {
                                    $("#list10_d").jqGrid('setGridParam', {url: "mostrarProductoInventario.htm?ids=" + ids, page: 1});
                                    $("#list10_d").jqGrid('setCaption', "DETALLE PRODUCTO ALMACEN: " + ids).trigger('reloadGrid');
                                }
                            } else {
                                $("#list10_d").jqGrid('setGridParam', {url: "mostrarProductoInventario.htm?ids=" + ids, page: 1});
                                $("#list10_d").jqGrid('setCaption', "DETALLE PRODUCTO ALMACEN: " + ids).trigger('reloadGrid');
                            }
                        }});
                    $("#list2").jqGrid('navGrid', '#pager10',
                            {add: false, edit: false, del: false});
                    $("#list10_d").jqGrid({
                        height: 'auto',
                        datatype: "json",
                        colNames:
                                ['NRO', 'COD. PRODUCTO', 'VARIEDAD', 'DESCRIPCION PROD.', 'UNID. MEDIDA', 'CANT.', 'PRECIO UNIT.'],
                        colModel:
                                [
                                    {name: 'inventarioid', index: 'inventarioid', width: 50, align: "center", sortable: false},
                                    {name: 'codigoproducto', index: 'codigoproducto', width: 100, align: "left", sortable: false},
                                    {name: 'denominacionV', index: 'denominacionV', width: 150, align: "left", sortable: false},
                                    {name: 'descripcionP', index: 'descripcionP', width: 250, align: "left", sortable: false},
                                    {name: 'denominacionUM', index: 'denominacionUM', width: 100, align: "center", sortable: false},
                                    {name: 'cantidad', index: 'cantidad', width: 100, align: "left", sortable: false},
                                    {name: 'preciounitario', index: 'preciounitario', width: 100, align: "left", sortable: false}
                                ],
                        rowNum: 5,
                        rowList: [5, 10, 20],
                        pager: '#pager10_d',
                        sortname: 'inventarioid',
                        viewrecords: true,
                        sortorder: "asc",
                        multiselect: true,
                        caption: "DETALLE PRODUCTO ALMACEN",
                        onSelectRow: function(id) {
                            var userCode = $("#list10_d").jqGrid('getGridParam', 'selrow');

                            if (userCode) {
                                var ret = $("#list10_d").jqGrid('getRowData', userCode);
                                $('#txtinventarioid').val(ret.inventarioid);
                                $('#txtcantidad').val(ret.cantidad);
                            }
                        }
                    }).navGrid('#pager10_d',
                            {add: false, edit: false, del: false});
                    $("#ms1").click(function() {
                        var s;
                        s = $("#list10_d").jqGrid('getGridParam', 'selarrrow');
                        $('#txtinventarioid').val(s);
                        $('#txtcantidad').val(s);
                    });

                });
            }
        </script>
        <script type="text/javascript">
            function  activoFormatter(cellvalue, options, rowObject) {
                var cellValueInt = cellvalue;
                var arr = cellvalue.split(',');
                if (cellValueInt == 'ACT')
                    return "<img src='img/elements/forms/icon-success.png' alt='" + cellvalue + "'title='" + cellvalue + "' />";
                else if (cellValueInt == 'INAC')
                    return "<img src='img/elements/alert-boxes/success.png' alt='" + cellvalue + "'title='" + cellvalue + "' />";
                else
                    return "<img src='img/elements/alert-boxes/error.png' alt='" + cellvalue + "'title='" + cellvalue + "' />";
            }
            function Activar(id) {
                $.ajax({
                    url: "activarPregunta.htm",
                    type: 'get',
                    data: "id=" + id,
                    dataType: "json",
                    success: function(rpt) {
                        $("#list").trigger("reloadGrid");
                    }
                });
            }
        </script>

        <script type="text/javascript">
            $$.ready(function() {
                $("#btnGuardar").click(function() {
                    var txtinventarioid = $('#txtinventarioid').val();
                    var txtcantidad = $('#txtcantidad').val();
                    var txtobservacion = $('#txtobservacion').val();



                    var object = {
                        txtinventarioid: txtinventarioid, txtcantidad: txtcantidad, txtobservacion: txtobservacion
                    };

                    $.ajax({
                        type: "get",
                        url: "registarOrdenCompra.htm",
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

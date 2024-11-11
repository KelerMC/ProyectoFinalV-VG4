<%-- 
    Document   : registrarCluster
    Created on : 29-sep-2013, 8:21:58
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

                    <legend>ORDEN DE COMPRA</legend>   
                    <div>
                        <!-- Invoice Header -->

                        <table id="list2"></table> 
                        <div id="pager2"></div> 
                        <br />
                        <!-- Invoice Detail -->

                        <table id="list10_d"></table>
                        <div id="pager10_d"></div>


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
                        url: "recuperarOrdenCompra.htm",
                        datatype: 'json',
                        mtype: 'GET',
                        height: 'auto',
                        width: 'auto',
                        colNames: ['NRO', 'COD. PROD.', 'CANT.', 'PRECIO UNIT.', 'UNID. MEDIDA', 'FEC. ORDEN', 'FEC. APROB.', 'VALOR VENTA', 'CLIENTE', 'ESTADO ORDEN'],
                        colModel: [
                            {name: 'ordencompraid', index: 'ordencompraid', width: 50, sortable: false, align: 'left'},
                            {name: 'codigoproducto', index: 'codigoproducto', width: 100, sortable: false, align: 'center'},
                            {name: 'cantidadOC', index: 'cantidadOC', width: 50, sortable: false, align: 'right'},
                            {name: 'preciounitario', index: 'preciounitario', width: 80, sortable: false, align: 'right'},
                            {name: 'denominacion', index: 'denominacion', width: 100, sortable: false, align: 'left'},
                            {name: 'fechaorden', index: 'fechaorden', width: 100, sortable: false, align: 'center'},
                            {name: 'fechaaprobacion', index: 'fechaaprobacion', width: 100, sortable: false, align: 'center'},
                            {name: 'valorventa', index: 'valorventa', width: 100, sortable: false, align: 'right'},
                            {name: 'nombrecompleto', index: 'nombrecompleto', width: 200, sortable: false, align: 'left'},
                            {name: 'estadoorden', index: 'estadoorden', width: 90, sortable: false, align: 'center', formatter: activoFormatter}
                        ],
                        rowNum: 10,
                        rowList: [10, 20, 30],
                        pager: '#pager2',
                        sortname: 'ordencompraid',
                        viewrecords: true,
                        loadonce: true,
                        sortorder: "desc",
                        multiselect: false,
                        caption: "LISTA DE ORDEN COMPRA",
                        onSelectRow: function(id) {
                            var ids = $('#list2').getCell(id, "codigoproducto");
                            if (ids == null) {
                                ids = 0;
                                if ($("#list10_d").jqGrid('getGridParam', 'records') > 0) {
                                    $("#list10_d").jqGrid('setGridParam', {url: "recuperarDetalleOrdenCompra.htm?ids=" + ids, page: 1});
                                    $("#list10_d").jqGrid('setCaption', "DETALLE ORDEN DE COMPRA: " + ids).trigger('reloadGrid');
                                }
                            } else {
                                $("#list10_d").jqGrid('setGridParam', {url: "recuperarDetalleOrdenCompra.htm?ids=" + ids, page: 1});
                                $("#list10_d").jqGrid('setCaption', "DETALLE ORDEN DE COMPRA: " + ids).trigger('reloadGrid');
                            }
                        }});
                    $("#list2").jqGrid('navGrid', '#pager10',
                            {add: false, edit: false, del: false});
                    $("#list10_d").jqGrid({
                        height: 'auto',
                        datatype: "json",
                        colNames:
                                ['NRO', 'SOCIO', 'VARIEDAD', 'CALIBRE', 'DES. CALIBRE', 'RANGO CALIBRE', 'PESO CALIBRE', 'DES. PROD.'],
                        colModel:
                                [
                                    {name: 'productoid', index: 'productoid', width: 50, align: "center", sortable: false},
                                    {name: 'nombrecompleto', index: 'nombrecompleto', width: 200, align: "left", sortable: false},
                                    {name: 'denominacionV', index: 'denominacionV', width: 100, align: "left", sortable: false},
                                    {name: 'denominacionC', index: 'denominacionC', width: 100, align: "left", sortable: false},
                                    {name: 'denominacionVC', index: 'denominacionVC', width: 100, align: "center", sortable: false},
                                    {name: 'rangoVC', index: 'rangoVC', width: 100, align: "center", sortable: false},
                                    {name: 'pesoVC', index: 'pesoVC', width: 100, align: "center", sortable: false},
                                    {name: 'descripcionPRO', index: 'descripcionPRO', width: 200, align: "left", sortable: false}
                                ],
                        rowNum: 5,
                        rowList: [5, 10, 20],
                        pager: '#pager10_d',
                        sortname: 'inventarioid',
                        viewrecords: true,
                        sortorder: "asc",
                        multiselect: true,
                        caption: "DETALLE ORDEN DE COMPRA"
                    }).navGrid('#pager10_d',
                            {add: false, edit: false, del: false});
                    $("#ms1").click(function() {
                        var s;
                        s = $("#list10_d").jqGrid('getGridParam', 'selarrrow');

                    });

                });
            }
        </script>

        <script>
            function getData55() {
                $(document).ready(function() {

                    $("#list").jqGrid({
                        url: "recuperarOrdenCompra.htm",
                        datatype: 'json',
                        mtype: 'GET',
                        height: 'auto',
                        width: 'auto',
                        colNames: ['NRO', 'COD. PROD.', 'CANT.', 'PRECIO UNIT.', 'UNID. MEDIDA', 'FEC. ORDEN', 'FEC. APROB.', 'VALOR VENTA', 'CLIENTE', 'ESTADO ORDEN'],
                        colModel: [
                            {name: 'ordencompraid', index: 'ordencompraid', width: 50, sortable: false, align: 'left'},
                            {name: 'codigoproducto', index: 'codigoproducto', width: 100, sortable: false, align: 'center'},
                            {name: 'cantidadOC', index: 'cantidadOC', width: 50, sortable: false, align: 'right'},
                            {name: 'preciounitario', index: 'preciounitario', width: 80, sortable: false, align: 'right'},
                            {name: 'denominacion', index: 'denominacion', width: 100, sortable: false, align: 'left'},
                            {name: 'fechaorden', index: 'fechaorden', width: 100, sortable: false, align: 'center'},
                            {name: 'fechaaprobacion', index: 'fechaaprobacion', width: 100, sortable: false, align: 'center'},
                            {name: 'valorventa', index: 'valorventa', width: 100, sortable: false, align: 'right'},
                            {name: 'nombrecompleto', index: 'nombrecompleto', width: 200, sortable: false, align: 'left'},
                            {name: 'estadoorden', index: 'estadoorden', width: 90, sortable: false, align: 'center', formatter: activoFormatter}
                        ],
                        multiselect: false,
                        paging: true,
                        rowNum: 10,
                        rowList: [10, 20, 30],
                        pager: $("#page"),
                        loadonce: true,
                        sortorder: "desc",
                        viewrecords: true,
                        caption: "LISTA DE ORDEN COMPRA",
                        onSelectRow: function() {
                            var com = $("#list").jqGrid('getGridParam', 'selrow');
                            Activar(com);
                        }
                    }).navGrid('#page', {edit: false, add: false, del: false});


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
    </body>
</html>

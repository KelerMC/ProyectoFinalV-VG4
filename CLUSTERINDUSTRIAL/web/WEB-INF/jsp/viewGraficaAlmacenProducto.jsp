<%-- 
    Document   : ver_crecimiento
    Created on : 12-sep-2012, 22:17:36
    Author     : Arango
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>UNIVERSIDAD NACIONAL DE SAN CRISTÓBAL DE HUAMANGA</title>

        <script type="text/javascript" src="js/grafica/jquery.min.js"></script>



        <script type="text/javascript">
            function doAjaxRecuperarPeso() {
                $(document).ready(function() {
                    $.ajax({
                        type: "GET",
                        url: "listarAlmacenInventario.htm",
                        dataType: "json",
                        cache: false,
                        success: function(response) {
                            getDataTalla(response);
                        },
                        error: function(e) {
                            alert('Error: ' + e.toSource());
                        }
                    });
                });
            }
        </script>


        <script type="text/javascript">
            function getDataTalla(data) {
                $(function() {
                    $('#container').highcharts({
                        chart: {
                            plotBackgroundColor: null,
                            plotBorderWidth: null,
                            plotShadow: false
                        },
                        title: {
                            text: 'ESTADÍSTICA DE CANTIDAD DE PRODUCTO POR ALMACÉN'
                        },
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                        },
                        plotOptions: {
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#000000',
                                    connectorColor: '#000000',
                                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                                }
                            }
                        },
                        series: [{
                                type: 'pie',
                                name: 'Browser share',
                                data: [
                                    [data.data2[0], data.data3[0]],
                                    [data.data2[1], data.data3[1]],
                                    {
                                        name: data.data2[2],
                                        y: data.data3[2],
                                        sliced: true,
                                        selected: true
                                    },
                                    [data.data2[3], data.data3[3]],
                                    [data.data2[4], data.data3[4]],
                                    [data.data2[5], data.data3[5]]
                                ]
                            }]
                    });
                });
            }
        </script>

        <script src="js/grafica/highcharts.js"></script>
        <script src="js/grafica/exporting.js"></script>



    </head>
    <body onload="doAjaxRecuperarPeso();">
        <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>      
    </body>
</html>
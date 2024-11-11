<%-- 
    Document   : listaCliente
    Created on : 08/12/2013, 01:45:22 PM
    Author     : ARANGO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UNIVERSIDAD NACIONAL DE SAN CRISTÓBAL DE HUAMANGA</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>

        <script type="text/javascript">
            $("#rowed5").jqGrid({
                url: 'listaDatoAhorro.htm',
                datatype: "json",
                colNames: ['IDAHAHORRO', 'DESCPROD', 'SLDODOC'],
                colModel: [
                    {name: 'idahahorro', index: 'idahahorro', width: 100, sortable: false, align: "right"},
                    {name: 'categdoc', index: 'categdoc', width: 300, sortable: false, align: "right"},
                    {name: 'sldodoc', index: 'sldodoc', width: 150, sortable: false, align: "right"}
                ],
                multiselect: false,
                paging: true,
                rowNum: 10,
                rowList: [10, 20, 30],
                pager: '#pager30',
                loadonce: true,
                sortorder: "desc",
                viewrecords: true,
                caption: "DATOS AHORRO - DEPOSITO",
                onSelectRow: function(id) {
                    var ids = $('#rowed5').getCell(id, "idahahorro");
                    if (ids == null)
                    {
                        ids = 0;
                        if ($("#list10_d").jqGrid('getGridParam', 'records') > 0)
                        {
                            $("#list10_d").jqGrid('setGridParam', {url: "listaDetalleAporte.htm?ids=" + ids, page: 1});
                            $("#list10_d").jqGrid('setCaption', "DETALLE AHORRO DEPOSITO " + ids).trigger('reloadGrid');
                        }
                    } else {
                        $("#list10_d").jqGrid('setGridParam', {url: "listaDetalleAporte.htm?ids=" + ids, page: 1});
                        $("#list10_d").jqGrid('setCaption', "DETALLE AHORRO DEPOSITO " + ids).trigger('reloadGrid');
                    }
                }});
            $("#rowed5").jqGrid('navGrid', '#pager30', {edit: false, add: false, del: false, search: false, refresh: false});
            $("#list10_d").jqGrid({
                height: 100,
                datatype: "json",
                colNames:
                        ['TRXCAJA', 'MTOCAPTRX', 'FECDOC', 'DESCRIPCION', 'INDDISMIN'],
                colModel: [
                    {name: 'idahdoccli', index: 'idahdoccli', width: 55, align: "right", sortable: false, search: false},
                    {name: 'mtocaptrx', index: 'mtocaptrx', width: 180, align: "right", sortable: false, search: false},
                    {name: 'fecdoc', index: 'fecdoc', width: 80, align: "right", sortable: false, search: false},
                    {name: 'descripcion', index: 'descripcion', width: 80, align: "right", sortable: false, search: false},
                    {name: 'inddismin', index: 'inddismin', width: 80, align: "right", sortable: false, search: false}
                ],
                multiselect: false,
                paging: true,
                rowNum: 10,
                rowList: [10, 20, 30],
                pager: '#pager10_d',
                loadonce: true,
                sortorder: "desc",
                viewrecords: true,
                caption: "DETALLE AHORRO DEPOSITO"
            }).navGrid('#pager10_d', {add: false, edit: false, del: false});
            $("#ms1").click(function() {
                var s;
                s = $("#list10_d").jqGrid('getGridParam', 'selarrrow');
                alert(s);
            });
        </script>

    </body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
  
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Pagina Principala</title>
<!-- Main page styles -->
    <link rel="stylesheet" href="resources/Css/mainPageCss.css" type="text/css" />
    <link rel="stylesheet" href="resources/Css/side-menu.css" type="text/css" />
<!-- JQWidgets dependencies -->
    <link rel="stylesheet" href="resources/JQWIDGETS/jqwidgets/styles/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="resources/JQWIDGETS/scripts/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxdata.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxinput.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxsplitter.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxdatatable.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxlistbox.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxcombobox.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxcheckbox.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxpanel.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxribbon.js"></script>
    <script type="text/javascript" src="resources/jsScripts/formModal.js"></script>
     
<!-- JQueryUI dependencies -->
    <link rel="stylesheet" href="resources/JqueryUI/jquery-ui.css">
    <script src="resources/JqueryUI/jquery-ui.js"></script>
<!-- jsStaticSources -->
    

 
</head>
<script>
$(document).ready(
  function() {
   
  $("#test").on("click",function(){
   $.ajax({
    url:"http://localhost:5080/executors/initPersonsAddForm?formType=privateForm",
    success:function(form){
     $("#wind").html(form);
      $.blockUI({ message: $('#PPForm') });
      generateForm();
      overrideSubmit();
     ;
    }
   });
  });
  });
</script>
<body>

<table style="width: 100%;height: 960px">
<tr style="width: 100%;height: 100%">
<td style="width: 100%;height: 100%">
<table style="width: 100%;height: 100%">
<tr style="width: 100%;height: 100%">
<td style="width: 80%;height: 100%">
<table  style="width: 100%;height: 100%">
<tr  style="width: 100%;height: 300px"><td  style="width: 100%;height: 100%">



</td></tr>
<tr  style="width: 100%;height: 600px;border-top:1px solid black">
<td>
<table  style="width: 100%;height: 100%">
<tr>
<td  style="width: 65%;height: 100%" valign="top">
<div id="solidarP" style="height:50%;position:relative;"></div>
<div id="coP" style="position:relative;"></div>
</td>
<td  style="width: 35%;height: 100%; border-left:1px solid black" valign="top">
<h1>Date despre persoana selectata:</h1>
<div id="selectedPerson"></div>
</td>
</tr>
</table>
</td>
</tr>
</table>
</td>
<td style="width: 20%;height: 100%; border-left:1px solid black;" valign="top">
<div id="menu">
<div class="persons-menu">
<p class="persons-menu-heading">Persoane</p>
<ul class="persons-menu-class">
<li id="deb"class="persons-menu-item"><p class="persons-menu-link">Debitor</p></li>
<li id="rdeb" class="persons-menu-item"><p class="persons-menu-link">Reprezentant Debitor</p></li>
<li id="cred" class="persons-menu-item"><p class="persons-menu-link">Creditor</p></li>
<li id="rcred" class="persons-menu-item"><p class="persons-menu-link">Reprezentant Creditor</p></li>
</ul>
</div>
</div>

</td>
</tr>
</table>
</td>
</tr>
</table>



<script type="text/javascript" src="resources/myJsWidgeds/formSubmitFunctions.js"></script> 
<script type="text/javascript" src="resources/myJsWidgeds/dataTableLoader.js"></script>
<script type="text/javascript" src="resources/myJsWidgeds/personButtonsHandle.js"></script>

</body></html>
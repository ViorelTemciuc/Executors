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
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxbuttongroup.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxgrid.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxgrid.pager.js"></script>
    <script type="text/javascript" src="resources/JQWIDGETS/jqwidgets/jqxgrid.selection.js"></script> 
    <script type="text/javascript" src="resources/jsScripts/formModal.js"></script>
     <script type="text/javascript" src="resources/myJsWidgeds/duplicateHandling.js"></script>
      <script type="text/javascript" src="resources/myJsWidgeds/initFilledForm.js"></script>
      <script type="text/javascript" src="resources/myJsWidgeds/searchButtonSourceHandling.js"></script>
    
<!-- JQueryUI dependencies -->
   <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
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

<table style="width: 100%;height: 100%">
<tr style="width: 100%;height: 100%">
<td style="width: 100%;height: 100%">
<table style="width: 100%;height: 100%">
<tr style="width: 100%;height: 100%">
<td style="width: 80%;height: 100%">
<table  style="width: 100%;height: 100%">
<tr  style="width: 100%"><td  style="width: 100%;height: 30%">



</td></tr>
<tr  style="width: 100%;border-top:1px solid black">
<td style="width: 100%;height: 60%">
<table  style="width: 100%;height: 100%">
<tr>
<td  style="width: 65%;height: 100%" valign="top">
<div id="Representy_P" style="height:50%;position:relative;z-index:1;margin-left:2%;display:none"></div>
<div id="Solidar_P" style="height:50%;position:relative;z-index:1;margin-left:2%"></div>
<div id="Co_P" style="position:relative;z-index:1;margin-left:2%"></div>
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
<div id="duplicate" style="display:none">
<h3>Asa persoana exista in Baza de Date:</h3>
<h4>Selectati persoana corecta din lista pentru a fi updatata</h4>
<p align="center" style="display:-moz-inline-grid"></p>
<span style="display:inherit;padding:10px"><button id="duplicateCancel" >Cancel</button></span>
</div>
<div id="dialog-confirm" title="Stergerea persoanei ?">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>
  Doriti eliminarea acestei persoane din Inchere si/sau din DB?</p>
</div>

<script type="text/javascript" src="resources/myJsWidgeds/formSubmitFunctions.js"></script> 
<script type="text/javascript" src="resources/myJsWidgeds/dataTableLoader.js"></script>
<script type="text/javascript" src="resources/myJsWidgeds/personButtonsHandle.js"></script>

</body></html>
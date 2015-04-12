<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
  
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Pagina Principala</title>
<!-- Main page styles -->
    <link rel="stylesheet" href="resources/Css/mainPageCss.css" type="text/css" />
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
<!-- JQueryUI dependencies -->
    <link rel="stylesheet" href="resources/JqueryUI/jquery-ui.css">
    <script src="resources/JqueryUI/jquery-ui.js"></script>
<!-- jsStaticSources -->
    <script type="text/javascript" src="resources/jsSources/staticSources.js"></script>
<!-- JsDomEvents -->
    <script type="text/javascript" src="resources/jsEvents/events.js"></script>
        <!-- FormLoadSources  -->
	<script type="text/javascript" src="resources/myJsWidgeds/formSources.js"></script>
<!-- JSDOMLoader File -->
    <script type="text/javascript" src="resources/jsScripts/mainDOMLoader.js"></script>
    <script type="text/javascript" src="resources/jsScripts/formSubscribeLoader.js"></script>
    <script type="text/javascript" src="resources/jsScripts/finalForm.js"></script>
<!-- FormSubscribeLoader  -->
	<script type="text/javascript" src="resources/myJsWidgeds/personsFormWidget.js"></script>
	<script type="text/javascript" src="resources/myJsWidgeds/personsSearchWidget.js"></script>
<!-- FormSubmits
	<script type="text/javascript" src="resources/jsScripts/formSubmits.js"></script> -->
</head>

<body>

<form>
<!-- Date debitor -->
<div class="persoane" name="main_persoane_div">
<div id="debitor_splitter"><!-- split la date despre persoane si forma de reprezentare in 2 paneluri-->
<div id="mainSplitter"><!-- main splitterul in 2 panel-->
<div class="splitter-panel"><!--panel1-->
<!-- Boxul cu date despre debitor -->
  <div class="persons_data_box">
     <input id="debitor_input" class="text_input_persons" name="Debitor"><!-- textbox autofill pentru Debitor --> 
<!-- button date debitor -->
     <span><input type="button" value="Nou" class='buton_insert_persoane' style="margin:5px" id="open_form_persons_debitor"></span>
     <span><div id='statut_juridic_debitor' class="statut_juridic"></div></span><!-- combobox debitor persoana fizica sau juridica -->
<!-- end button debitor -->
  </div>
<!-- end Box date persoana -->
  <div id="reprezentant_debitor_checkbox" style="margin-left: 10px; float: left;"><span>Reprezentant</span></div> <!-- checkbox daca debitorul are reprezentant -->
<!-- Date reprezentant debitor -->
<div id="reprezentant_debitor" class="hidden">
<div class="persons_data_box">
     <input id="reprezentant_debitor_input" class="text_input_persons" name="reprezentant_Debitor"><!-- textbox autofill pentru Debitor --> 
<!-- button date debitor -->
     <span><input type="button" value="..." class='buton_insert_persoane' id="open_form_persons_reprezentant_debitor"></span>
     <div id='statut_juridic_reprezentant_debitor' class="statut_juridic" style="margin-left:5px;"></div><!-- combobox debitor persoana fizica sau juridica -->
<!-- end button debitor -->
</div> 
</div>



</div><!--end panel1 -->
<div class="splitter-panel">
    <div id="forma_add_persoane"></div>
    <div id="datePersoane" style="float:right;display:none">
        <ul id="header" style="width:115px;">
            <li>Debitor</li>
            <li>Reprezentant</li>
            <li>Creditor</li>
            <li>Reprezentant</li>
        </ul>
    <div>
    <div id="debitor_data"></div>
    <div id="reprez_debitor_data"></div>
    <div id="creditor_data"></div>
    <div id="reprez_creditor_data"></div>
    </div>
    
</div><!--end panel2 -->
<div id="bottomTable"></div>
</div><!--end MainSplitter-->
</div><!-- end debitor spliter -->

</div>
<br>
<br>
</form>
</body></html>

<#assign timeStampFormat = config.getValue('timeStampFormat')>
<#assign cdn = config.getValue('cdn')>

<head>
	<meta charset='${ config.getValue('encoding') }' /> 
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<meta name='description' content='' />
	<meta name='robots' content='noodp, noydir' />
	<meta name='viewport' content='width=device-width, initial-scale=1' />
	<meta id="timeStampFormat" name="timeStampFormat" content='${timeStampFormat}'/>
	
	<link href='css/source_sans.css' rel='stylesheet' type='text/css'>
	<link href="css/material_icons.css" rel="stylesheet">

	<#if cdn == 'extentreports'>
		<link href='css/extent.css' type='text/css' rel='stylesheet' />
	<#else>
		<link href='css/extent.css' type='text/css' rel='stylesheet' />
	</#if>
	
	<title>${ config.getValue('documentTitle') }</title>

	<#if config.containsKey('css')>
	<style type='text/css'>
		${ config.getValue('css') }
	</style>
	</#if>
</head>

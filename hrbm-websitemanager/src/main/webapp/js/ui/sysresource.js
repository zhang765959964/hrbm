
(function(){
	var modules = {
		draggable:{
			js:'jquery.draggable.js'
		},
		droppable:{
			js:'jquery.droppable.js'
		},
		resizable:{
			js:'jquery.resizable.js'
		},
		linkbutton:{
			js:'jquery.linkbutton.js',
			css:'linkbutton.css'
		},
		progressbar:{
			js:'jquery.progressbar.js',
			css:'progressbar.css'
		},
		tooltip:{
			js:'jquery.tooltip.js',
			css:'tooltip.css'
		},
		pagination:{
			js:'jquery.pagination.js',
			css:'pagination.css',
			dependencies:['linkbutton']
		},
		datagrid:{
			js:'jquery.datagrid.js',
			css:'datagrid.css',
			dependencies:['panel','resizable','linkbutton','pagination']
		},
		treegrid:{
			js:'jquery.treegrid.js',
			css:'tree.css',
			dependencies:['datagrid']
		},
		propertygrid:{
			js:'jquery.propertygrid.js',
			css:'propertygrid.css',
			dependencies:['datagrid']
		},
		datalist:{
			js:'jquery.datalist.js',
			css:'datalist.css',
			dependencies:['datagrid']
		},
		panel: {
			js:'jquery.panel.js',
			css:'panel.css'
		},
		window:{
			js:'jquery.window.js',
			css:'window.css',
			dependencies:['resizable','draggable','panel']
		},
		dialog:{
			js:'jquery.dialog.js',
			css:'dialog.css',
			dependencies:['linkbutton','window']
		},
		messager:{
			js:'jquery.messager.js',
			css:'messager.css',
			dependencies:['linkbutton','window','progressbar']
		},
		layout:{
			js:'jquery.layout.js',
			css:'layout.css',
			dependencies:['resizable','panel']
		},
		form:{
			js:'jquery.form.js'
		},
		menu:{
			js:'jquery.menu.js',
			css:'menu.css'
		},
		tabs:{
			js:'jquery.tabs.js',
			css:'tabs.css',
			dependencies:['panel','linkbutton']
		},
		menubutton:{
			js:'jquery.menubutton.js',
			css:'menubutton.css',
			dependencies:['linkbutton','menu']
		},
		splitbutton:{
			js:'jquery.splitbutton.js',
			css:'splitbutton.css',
			dependencies:['menubutton']
		},
		accordion:{
			js:'jquery.accordion.js',
			css:'accordion.css',
			dependencies:['panel']
		},
		calendar:{
			js:'jquery.calendar.js',
			css:'calendar.css'
		},
		textbox:{
			js:'jquery.textbox.js',
			css:'textbox.css',
			dependencies:['validatebox','linkbutton']
		},
		filebox:{
			js:'jquery.filebox.js',
			css:'filebox.css',
			dependencies:['textbox']
		},
		combo:{
			js:'jquery.combo.js',
			css:'combo.css',
			dependencies:['panel','textbox']
		},
		combobox:{
			js:'jquery.combobox.js',
			css:'combobox.css',
			dependencies:['combo']
		},
		combotree:{
			js:'jquery.combotree.js',
			dependencies:['combo','tree']
		},
		combogrid:{
			js:'jquery.combogrid.js',
			dependencies:['combo','datagrid']
		},
		validatebox:{
			js:'jquery.validatebox.js',
			css:'validatebox.css',
			dependencies:['tooltip']
		},
		numberbox:{
			js:'jquery.numberbox.js',
			dependencies:['textbox']
		},
		searchbox:{
			js:'jquery.searchbox.js',
			css:'searchbox.css',
			dependencies:['menubutton','textbox']
		},
		spinner:{
			js:'jquery.spinner.js',
			css:'spinner.css',
			dependencies:['textbox']
		},
		numberspinner:{
			js:'jquery.numberspinner.js',
			dependencies:['spinner','numberbox']
		},
		timespinner:{
			js:'jquery.timespinner.js',
			dependencies:['spinner']
		},
		tree:{
			js:'jquery.tree.js',
			css:'tree.css',
			dependencies:['draggable','droppable']
		},
		datebox:{
			js:'jquery.datebox.js',
			css:'datebox.css',
			dependencies:['calendar','combo']
		},
		datetimebox:{
			js:'jquery.datetimebox.js',
			dependencies:['datebox','timespinner']
		},
		slider:{
			js:'jquery.slider.js',
			dependencies:['draggable']
		},
		tooltip:{
			js:'jquery.tooltip.js'
		},
		parser:{
			js:'jquery.parser.js'
		},
		mobile:{
			js:'jquery.mobile.js'
		}
	};
})();

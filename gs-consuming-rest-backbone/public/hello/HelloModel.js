define(function(require) {
	var Backbone = require('Backbone');

	return Backbone.Model.extend({
		urlRoot : 'http://localhost:8080/greeting',
		url : function() {
			return this.urlRoot + '?name=' + this.id;
		}
	});

});

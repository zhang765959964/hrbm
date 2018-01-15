;(function($, window, document, undefined) {

	jQuery.fn.extend({
		getAge : function() {
			var unId = $(this).val();

			var myDate = new Date();
			var month = myDate.getMonth() + 1;
			var day = myDate.getDate();
			var age = myDate.getFullYear() - unId.substring(6, 10) - 1;
			if (unId.substring(10, 12) < month
					|| unId.substring(10, 12) == month
					&& unId.substring(12, 14) <= day) {
				age++;
			}
			return age;

		},
		getBirthday : function() {
			var unId = $(this).val();

			return unId.substring(6, 10) + "-" + unId.substring(10, 12) + "-"
					+ unId.substring(12, 14);

		},
		getGender : function() {
			var unId = $(this).val();

			if (parseInt(unId.substr(16, 1)) % 2 == 1) {
				return '男';
			} else {
				return '女';
			}

		}

	});

})(jQuery, window, document);
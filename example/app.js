/**
 * Sample app using OpenBack
 */


var win = Ti.UI.createWindow({
	backgroundColor:'white'
});
var label = Ti.UI.createLabel();
win.add(label);
win.open();

// TODO: write your module tests here
var OpenBack = require('com.openback');
Ti.API.info("module is => " + OpenBack);

label.text = OpenBack.version();

OpenBack.coppaCompliant(true);
OpenBack.gdprForgetUser(false);

OpenBack.logGoal("Test", 1, 12.3);
OpenBack.logGoal("Test2", 3, 5);

OpenBack.setCustomTrigger(OpenBack.CUSTOM_TRIGGER_1, "customString");
OpenBack.setCustomTrigger(OpenBack.CUSTOM_TRIGGER_2, 123);
OpenBack.setCustomTrigger(OpenBack.CUSTOM_TRIGGER_3, 2.56);

OpenBack.setUserInfo({
	'firstName': 'John',
	'surName': 'Doe',
	'emailAddress': 'john@doe.com'
});
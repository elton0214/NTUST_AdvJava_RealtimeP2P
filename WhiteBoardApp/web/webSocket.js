
/*  This script will initiate the session handshake with the server when
 *  websocket.js is loaded by the browser.
 */

var wsUri01 ="ws://" +document.location.host +document.location.pathname  +"whiteboardendpoint";
var websocket01 =new WebSocket(wsUri01);

websocket01.onError =function(input_evt) { onError01(input_evt); };
function onError01(input_evt) {
    writeToScreen('<span style="color: red;"> ERROR</span>' +input_evt.data);
}

websocket01.onmessage =function(input_evt) { onMessage01(input_evt); };
function onMessage01(input_evt) {
    console.log("received: " +input_evt);
    drawImageText01(input_evt.data);
}//get, and give data to function drawImageText01() from whiteboard.js

function sendText01(input_json) {
    console.log("sending text: " +input_json);
    websocket01.send(input_json);
}



//// For testing purpose
//var output01 =document.getElementById("testing");
//websocket01.onopen =function(input_evt) { onOpen(input_evt); };
//function onOpen(){
//    writeToScreen("Connectied to " +wsUri01);
//}
//
//function writeToScreen(input_message) {
//    output01.innerHTML +=input_message +"<br>";
//}


// End test functions


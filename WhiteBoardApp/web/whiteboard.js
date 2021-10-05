/* 
 * Add the following getCurrentPos, defineImage and drawImageText methods
 *  to construct the JSON structure and send it to the endpoint (sendText(json)).
 */

//> The HTMLCanvasElement.getContext(contextType) method returns a drawing context on the
// canvas, or null if the context identifier is not supported.contextType is a DOMString.
var canvas01 = document.getElementById("myCanvas");
var context01 =canvas01.getContext("2d");
canvas01.addEventListener("click", defineImage01, false);

//>.getBoundingClientRect is a DOM, returns left, top, right, bottom, x, y, 
// width, and height properties describing the overall border-box in pixels.
//-----be used for method defineImage01()-----
function getCurrentPos01(input_evt){
    var rect01 =canvas01.getBoundingClientRect();   
    return{
        cPx: input_evt.clientX -rect01.left,
        cPy: input_evt.clientY -rect01.top
    };
}
function drawImageText01(input_JsonImage){
    console.log("drawImageText..."); //類似 print
    var JSObj01 =JSON.parse(input_JsonImage); // convert json file to JavaScript Object
    context01.fillStyle =JSObj01.j_color;
    switch (JSObj01.j_shape) {
        case "circle":
            context01.beginPath();
            context01.arc(JSObj01.j_coords.jc_x, JSObj01.j_coords.jc_y, 5, 0, 2*Math.PI, false);
            context01.fill();
            break;
        case "square":
        default:
            context01.fillRect(JSObj01.j_coords.jc_x, JSObj01.j_coords.jc_y, 10, 10);
            break;
    }
}//將收到的JSON檔，轉成JavaScript Object，再畫畫
//----------------------------------------

function defineImage01(input_evt){
    var currentPos01 =getCurrentPos01(input_evt); //so there are cPx, cPy inside currentPos01
    for (i=0; i<document.xInputForm.xColor.length; i++) {
        if (document.xInputForm.xColor[i].checked) {
            var color01 =document.xInputForm.xColor[i];
            break;
        }
    }//選擇color
    for (i=0; i<document.xInputForm.xShape.length; i++) {
        if (document.xInputForm.xShape[i].checked) {
            var shape01 =document.xInputForm.xShape[i];
            break;
        }
    }//選擇shape
    var json01 =JSON.stringify({
        "j_color": color01.value,
        "j_shape": shape01.value,   
        "j_coords": {
            "jc_x": currentPos01.cPx,
            "jc_y": currentPos01.cPy
        }
    });//將PositionCoordinate,color,shape 包成json
    
    drawImageText01(json01); //this method is at webSocket.js
    sendText01(json01); //this method is at webSocket.js
}


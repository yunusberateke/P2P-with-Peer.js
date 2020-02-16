var my_id_tag = document.getElementById("myid");
var videoanswer = document.getElementById("vv2");

var peer = new Peer();

peer.on('open', (id)=> {
    my_id_tag.innerText = my_id_tag.innerText + id
});

const constraints = {
    video: true
  };
  
const video = document.querySelector('video');

navigator.getUserMedia({video: true, audio: true}, 
    function(stream) {
        video.srcObject = stream;
        peer.on('call', function(call) {
            call.answer(stream); // Answer the call with an A/V stream.
            call.on('stream', function(remoteStream) {
                console.log("stream");
                
            })
        });    
    },
    function(e){
        console.log(e);
    });


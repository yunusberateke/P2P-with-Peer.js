var video = document.querySelector('video');

function hasUserMedia() {
    //check if the browser supports the WebRTC 
    return !!(navigator.getUserMedia || navigator.webkitGetUserMedia ||
        navigator.mozGetUserMedia);
}

if (hasUserMedia()) {
    navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia
        || navigator.mozGetUserMedia;

    navigator.getUserMedia({ video: true, audio: true }, function (stream) {
        console.log(stream);
        
        //inserting our stream to the video tag     
        this.stream = stream;
        
    }, function (err) { });
};


/*--  Peer --*/
var peerConfig = { 'iceServers': [{ 'url': 'stun:stun.l.google.com:19302' }] }
var peer = new Peer({key: 'lwjd5qra8257b9', config:peerConfig});

peer.on('open', function(id) {
  console.log("Successful peer created!")
  console.log(id);
});

var peerId = peer.id;
var conn = peer.connect(peerId);

peer.on('connection', function(conn) { 
    console.log("Peer Connected!")
});

var call = peer.call(peerId,this.stream);

peer.on('call', function(call) {
  // Answer the call, providing our mediaStream
  call.answer(stream);
  
  call.on('stream', function(stream) {
    video.srcObject = stream;
  // `stream` is the MediaStream of the remote peer.
  // Here you'd add it to an HTML video/canvas element.
});
});

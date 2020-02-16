var video = document.getElementById("vv");
var peer = new Peer(null, {
    debug: 2
});


peer.on('error', function(err) { 
    console.log(err);
    
 });

function connectButtonClick(){
    const video = document.querySelector('video');
    const anotherid = document.getElementById('anotherid').value;

    
    const createEmptyAudioTrack = () => {
        const ctx = new AudioContext();
        const oscillator = ctx.createOscillator();
        const dst = oscillator.connect(ctx.createMediaStreamDestination());
        oscillator.start();
        const track = dst.stream.getAudioTracks()[0];
        return Object.assign(track, { enabled: false });
      };
      
    const createEmptyVideoTrack = ({ width, height }) => {
        const canvas = Object.assign(document.createElement('canvas'), { width, height });
        canvas.getContext('2d').fillRect(0, 0, width, height);
      
        const stream = canvas.captureStream();
        const track = stream.getVideoTracks()[0];
      
        return Object.assign(track, { enabled: false });
      };
    
      const audioTrack = createEmptyAudioTrack();
      const videoTrack = createEmptyVideoTrack({ width:640, height:480 });
      const mediaStream = new MediaStream([audioTrack, videoTrack]);
    
    var call = peer.call(anotherid, mediaStream);
    call.on('stream', function(remoteStream) {
        video.srcObject = remoteStream;
        video.onloadedmetadata = function(e) {
            video.play();
          };        
    });

    /*
    navigator.getUserMedia({video: true, audio: true}, function(stream) {
        // Not solved this problem
        // stream = null 
        const audioCtx = new (window.AudioContext || window.webkitAudioContext)()
        const dest = audioCtx.createMediaStreamDestination ();
        call.answer()

        var call = peer.call(anotherid, stream);
        call.on('stream', function(remoteStream) {
            video.srcObject = remoteStream;        
        });
        },function(e) {
            console.log(e);
        });

    navigator.getUserMedia({video: true, audio: true}, function(stream) {
        var call = peer.call(anotherid, stream);
        call.on('stream', function(remoteStream) {
            video.srcObject = remoteStream;        
        });
    },function(e) {
        console.log(e);
    });



    */
}
    


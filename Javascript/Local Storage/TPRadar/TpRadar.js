var zoneDeTexte;
var displayGlobalSpeed;
var displayTempoSpeed;
var displayMaxSpeed;
var start;
var tempo;
var charTempo;
var eraseButton;
var maxSpeedPerMinute = 0;
var oldMaxSpeed = localStorage.getItem('record');
var timer = 5000;

//Récupérer le choix de l'utilisateur pour le timer

function startApp() {
    zoneDeTexte = document.getElementById('type-text');
    displayGlobalSpeed = document.getElementById('par1');
    displayTempoSpeed = document.getElementById('par2');
    displayMaxSpeed = document.getElementById('par3');
    eraseButton = document.getElementById('erase');
    zoneDeTexte.addEventListener('focus', radar);
    if(oldMaxSpeed) {
        displayMaxSpeed.innerHTML = oldMaxSpeed;
    }
}

function radar() {
    start = Date.now();
    tempo = start;
    charTempo = 0;
    countdown(timer);
}

function countdown(timing) {
    setTimeout(refresh, timer)
}

function refresh() {
    var now = Date.now();
    var charNumber = zoneDeTexte.value.length;
    var duration = now - start;
    var durationTempo = now - tempo;
    var charOnDurationTempo = charNumber - charTempo;

    var typeSpeed = parseInt(charNumber*1000 / (duration/60));
    var tempoTypeSpeed = parseInt(charOnDurationTempo*1000 / (duration/60));
    if(typeSpeed > maxSpeedPerMinute) {
        maxSpeedPerMinute = typeSpeed;
        localStorage.setItem('record', maxSpeedPerMinute)
    }

    displayGlobalSpeed.innerHTML = typeSpeed;
    displayTempoSpeed.innerHTML = tempoTypeSpeed;
    displayMaxSpeed.innerHTML = maxSpeedPerMinute;
    charTempo = charNumber;
    tempo = now;

    countdown(timer);
}

function eraseData() {
    if(confirm("Voulez vous vraiment supprimer le record ?")) {
        localStorage.removeItem('record')
        displayMaxSpeed.innerHTML = "";
    } else {
        console.log("Une erreur est survenue...");
    }
}
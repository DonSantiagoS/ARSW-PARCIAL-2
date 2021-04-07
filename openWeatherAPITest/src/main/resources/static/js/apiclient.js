var apiclient = (function () {

	let url="https://buitrago-arsw-t2.herokuapp.com/weather/";

    function buscar(ciudad,callback,errorCallback){
        axios({
            method: "get",
            url: url+ciudad,
        })
            .then(response => {callback(response.data,ciudad);})
            .catch(error => {errorCallback("No existe informacion del clima de: "+ciudad);})
    }

    function initMap(ciudad){
        fetch(url+ciudad)
            .then(function(response){return response.json()})
            .then(app.plotMarkers);
    }

    return {
        buscar:buscar,
        initMap:initMap
    };

})();
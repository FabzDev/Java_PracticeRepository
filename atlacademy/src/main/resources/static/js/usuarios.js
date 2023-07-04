// Call the dataTables jQuery plugin
$(document).ready(function() {

  $('#usuarios').DataTable();
});

 async function cargarUsuarios(){

     const request = await fetch("usuario/123", {
     method: 'GET'",
     headers: {
     "Accept": "application/json",
     "Content-Type": "application/json"
 }
 });
    const usuariosContent = await request.json();

    console.log(usuariosContent);
 }
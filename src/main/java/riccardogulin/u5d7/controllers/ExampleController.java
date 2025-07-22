package riccardogulin.u5d7.controllers;

import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d7.payloads.NewUserPayload;

@RestController // Specializzazione di @Component, quindi all'avvio dell'applicazione Spring creerà un oggetto di tipo ExampleController
// e lo aggiungerà allo "scatolone"
// Al suo interno definiremo una collezione di endpoints. Ogni endpoint sarà definito come metodo di questa classe con delle opportune annotazioni
// @Controller invece è l'annotazione da NON usare in quanto non specifica come RestController e ci costringerebbe a fare lavoro extra
@RequestMapping("/examples") // Tutti gli endpoint di questo controller avranno come parte comune dell'url /examples (http://localhost:3001/examples)
public class ExampleController {

	@GetMapping // Per contattare questo endpoint la richiesta sarà: GET -> http://localhost:3001/examples
	public String getExample() {
		return "Ciao, io sono l'endpoint che risponde alla GET";
	}

	@GetMapping("/getExample") // Per contattare questo endpoint la richiesta sarà: GET -> http://localhost:3001/examples/getExample
	public String getExample2() {
		return "Anche io rispondo alle GET, ma su un URL diverso";
	}

	@PostMapping // Per contattare questo endpoint la richiesta sarà: POST -> http://localhost:3001/examples
	public String postExample() {
		return "Io rispondo alle POST";
	}

	@PostMapping("/postExample") // Per contattare questo endpoint la richiesta sarà: POST -> http://localhost:3001/examples/postExample
	public String postExample2() {
		return "Anche io rispondo alle POST";
	}

	@PutMapping("/putExample") // Per contattare questo endpoint la richiesta sarà: PUT -> http://localhost:3001/examples/putExample
	public String putExample() {
		return "Io rispondo alle PUT";
	}

	@PatchMapping("/patchExample") // Per contattare questo endpoint la richiesta sarà: PATCH -> http://localhost:3001/examples/patchExample
	public String patchExample() {
		return "Io rispondo alle PATCH";
	}

	@DeleteMapping("/deleteExample") // Per contattare questo endpoint la richiesta sarà: DELETE -> http://localhost:3001/examples/deleteExample
	public String deleteExample() {
		return "Io rispondo alle DELETE";
	}

	// ***************************************************** QUERY PARAMETERS *********************************************
	// Ad es: http://localhost:3001/queryParamsExample?name=Giorgio&age=30, i query params sono quelli che seguono il punto di domanda e sono coppie chiave-valore

	@GetMapping("/queryParamsExample")
	public String queryParamsExample(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
		// Di default i query params sono OBBLIGATORI, se non li passo ottengo un 400 BAD REQUEST. Volendo posso però renderli opzionali
		// usando @RequestParam(required = false), attenzione però che in questo caso i parametri non passati saranno NULL!
		return "I parametri inseriti sono: " + name.toLowerCase() + ", " + age;
	}

	// *********************************************************** PATH PARAMETERS *******************************************
	@GetMapping("/pathParamExample/{param}") // Per contattare questo endpoint dovrò fare GET -> http://localhost:3001/pathParamExample/123123213
	// Con le graffe identifico il "segnaposto" per il parametro, che dovrà chiamarsi in maniera IDENTICA a quello che specifichiamo tra le tonde qua sotto
	public String pathParamExample(@PathVariable String param) {
		return "Il parametro che hai inserito è: " + param;
	}

	// ********************************************************* REQUEST BODY ************************************************
	@PostMapping("/payloadExample")
	public NewUserPayload payloadExample(@RequestBody NewUserPayload body) {
		// Per poter accedere al body della richiesta devo innanzitutto utilizzare l'annotazione @RequestBody
		// Seconda cosa, devo specificare il TIPO del body, se usassi String, funzionerebbe ma avrei a disposizione del testo
		// cosa veramente poco utile. Una mossa più furba invece è dichiarare una classe apposita che rappresenti esattamente
		// le caratteristiche del payload. In questa maniera Spring Web si occuperà di convertire il JSON in un oggetto vero
		// e proprio che potrò quindi utilizzare nel mio codice (ad es. potrò salvarlo nel DB)
		System.out.println(body.getName());
		System.out.println(body.getSurname());

		return body;
		// Anche per quanto riguarda il tipo di ritorno dell'endpoint posso, invece che usare String (il quale mi creerà
		// un payload di tipo text/plain), usare mia CLASSE CUSTOM. Così facendo, Spring mi convertirà l'oggetto JAVA in un
		// payload JSON che verrà inviato come risposta.

	}


}

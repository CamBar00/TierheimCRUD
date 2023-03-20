<template>
  <div class="container">
    <br /><br />
    <h1 class="text-center">Tier Registrierung</h1>
    <form>
      <div class="row">
        <div class="col-md-3 pb-3">
          <label for="inputName">Name</label>
          <input
            type="text"
            class="form-control"
            id="inputName"
            placeholder="Tiername"
            v-model="tier.tiername"
          />
        </div>
        <div class="row">
          <div class="col-md-6 pb-3">
            <label for="inputArt">Art</label>
            <input
              type="text"
              class="form-control"
              id="inputArt"
              placeholder="Tierart (Hund, Katze, Kaninchen, ...)"
              v-model="tier.tierart"
            />
          </div>
          <div class="col-md-6 pb-3">
            <label for="inputRasse">Rasse</label>
            <input
              type="text"
              class="form-control"
              id="inputRasse"
              placeholder="Tierasse (Labrador, Golden Retriever, ...)"
              v-model="tier.tierrasse"
            />
          </div>
        </div>
      </div>
      <div class="form-group col-md-2 pb-3">
        <label for="inputGeschlecht">Geschlecht</label>
        <select
          id="inputState"
          class="form-control"
          v-model="tier.tiergeschlecht"
        >
          <option selected>Geschlecht...</option>
          <option>Maennlich</option>
          <option>Weiblich</option>
          <option>...</option>
        </select>
      </div>
      <div class="form-row">
        <div class="form-group col-md-6 pb-3">
          <label for="inputGeburstag">Geburtstag</label>
          <input
            type="text"
            class="form-control"
            id="inputGeburstag"
            placeholder="Geburtsdatum"
            v-model="tier.tiergeburtstag"
          />
        </div>
        <div class="form-group col-md-6">
          <label for="inputBild">Bild</label>
          <input
            type="text"
            class="form-control"
            id="inputBild"
            v-model="tier.tierbild"
            placeholder="Bild-URL"
          />
        </div>
      </div>

      <button type="submit" class="btn btn-primary my-5" @click="save">
        Registrieren
      </button>
      <button type="submit" class="btn btn-primary my-5" @click="getAll">
        Alle Tiere
      </button>

      <div>{{ results[0].tiername }}</div>
    </form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "TierCrud",
  data() {
    return {
      results: {},
      tier: {
        tierid: "",
        tiername: "",
        tierart: "",
        tiergeschlecht: "",
        tierrasse: "",
        tiergeburtstag: "",
        tierbild: ""
      }
    };
  },
  methods: {
    save() {
      axios
        .post("http://localhost:8083/api/v1/tier/save", {
          tierid: this.tier.tierid,
          tiername: this.tier.tiername,
          tierart: this.tier.tierart,
          tiergeschlecht: this.tier.tiergeschlecht,
          tiergeburtstag: this.tier.tiergeburtstag,
          tierrasse: this.tier.tierrasse,
          tierbild: this.tier.tierbild
        })
        .then(response => {
          console.log(response);
          this.tier.tierart = "";
          this.tier.tierbild = "";
          this.tier.tiergeburtstag = "";
          this.tier.tiergeschlecht = "";
          this.tier.tierid = "";
          this.tier.tiername = "";
          this.tier.tierrasse = "";
        })
        .catch(error => {
          console.log(error);
        });
    },
    getAll() {
      axios
        .get("http://localhost:8083/api/v1/tier/getAllTiere")
        .then(response => {
          this.results = response.data;
          console.log(response);
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>
<style></style>

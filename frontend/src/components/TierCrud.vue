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
      <button type="submit" class="btn btn-success my-5" @click="getAll">
        Alle Tiere
      </button>
      <button type="submit" class="btn btn-warning my-5" @click="">
        Bearbeiten
      </button>

      <div class="d-flex flex-row row">
        <div v-if="results != ' '" v-for="tier in results" class="col-sm">
          <div class="card my-5 mx-3" style="width:18rem;height:auto;">
            <img class="card-img-top" :src="tier.tierbild" alt="Tier Bild" />
            <div class="card-body">
              {{ tier.tiername }} - {{ tier.tierart }}
              <div>Rasse: {{ tier.tierrasse }}</div>
              <div>Geschlecht: {{ tier.tiergeschlecht }}</div>
              <button
                type="submit"
                class="btn btn-danger mt-5"
                @click="deleteAnimal(tier)"
                :v-model="tier.tierid"
              >
                Löschen
              </button>
            </div>
          </div>
        </div>
      </div>
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
          this.getAll();
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
    },
    deleteAnimal(tier) {
      axios
        .delete(`http://localhost:8083/api/v1/tier/deletetier/${tier.tierid}`, {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Headers": "*"
          }
        })
        .then(response => {
          console.log("deletedd");
          this.getAll();
        });
    }
  }
};
</script>
<style>
.card-img-top {
  width: 100%;
  height: 15vw;
  object-fit: cover;
}
</style>

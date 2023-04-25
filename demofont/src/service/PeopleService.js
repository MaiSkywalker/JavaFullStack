import axios from "axios";

const PEOPLE_REST_API_URL = "http://localhost:8080/getallpeople"

class PeopleService {
    getAllPeople(){
        return axios.get(PEOPLE_REST_API_URL);
    }
}

export default new PeopleService();
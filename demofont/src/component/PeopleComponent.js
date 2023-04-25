import PeopleService from "../service/PeopleService";
import React from 'react';

class PeopleComponent extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            peopleList:[]
        }
    }

    componentDidMount(){
        PeopleService.getAllPeople().then((response) => {
            this.setState({ peopleList: response.data})
        });
    }

    render (){
        return (
            <div>
                <h1 className = "text-center"> People List</h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td> People Id</td>
                            <td> People Name</td>
                            <td> People Surname</td>
                            <td> People Age</td>
                            <td> People City</td>
                            <td>
                                <button className="add">Add</button>
                            </td>
                        </tr>
                    </thead>

                    <tbody>
                    {
                        this.state.peopleList.map(
                            people =>
                                <tr key = {people.id}>
                                    <td> {people.id}</td>
                                    <td> {people.name}</td>
                                    <td> {people.surname}</td>
                                    <td> {people.age}</td>
                                    <td> {people.city}</td>
                                    <td>
                                        <button className="edit">Edit</button>
                                        <button className="delete">Delete</button>
                                    </td>
                                </tr>
                        )
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

/*function add(){
    return(
        <form className="add">
            <input type="text" name="name" placeholder="Enter a name"/>
            <input type="text" name="surname" placeholder="Enter a surname"/>
            <input type="text" name="age" placeholder="Enter an age"/>
            <input type="text" name="city" placeholder="Enter a city"/>
            <button type="submit"> Add </button>
        </form>
    )
}*/
export default PeopleComponent
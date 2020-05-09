import React, {Component} from 'react';

class QuickSort extends Component {
    constructor(props) {
        super(props);
        this.state = {
                    unsortedArray:"7 6 9 3 10 1 2 80 50 5 3 10 6",
                    sortedArray:""
        };
        this.handleChange = this.handleChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        }

    componentDidMount() {
        this.onSubmit(null);
    }

    handleChange(e) {

        this.setState({unsortedArray:e.target.value});
    }

    onSubmit(e) {
        if (e!= null) {
            e.preventDefault();
        }
        fetch('/api/quicksort', {
                               method: 'POST',
                               headers: {
                                     'Content-Type': 'application/json'
                               },
                               body: JSON.stringify({unsortedArray:this.state.unsortedArray,
                               sortedArray:this.state.sortedArray})
                                })
                                .then(response => response.text())
                                .then(message => {
                                    this.setState({
                                    unsortedArray:this.state.unsortedArray,
                                    sortedArray:message
                                });
                            });
    }

    render = () => {
        return (
            <div>
            <form onSubmit={(event) => this.onSubmit(event)}>
                <br/>
                <label>
                    Type space separated elements of profit array:
                </label>
                <input type="text" name="unsortedArray" value={this.state.unsortedArray} onChange={this.handleChange}/>
                    <br/><br/>
                <input type="submit" value="Submit"/>
            </form>
            <p>Answer for the current inputs is {this.state.sortedArray}</p>
            <br/>
            <p>Navigate to other problems</p>
            <br/>
            </div>
        );
    }
}

export default QuickSort;
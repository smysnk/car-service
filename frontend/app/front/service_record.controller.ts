declare var require:any;

class ServiceRecordCtrl {

    private $todo:any;
    private $scope:any;
    private labelNewTodo:any;
    private list:any;
    private showMode:any;
    private countTasksRemaining:any;
    private remove:any;

    public static $inject = [
        '$scope',
        '$serviceRecord'
    ];

    public static initailize(mod) {
        mod.controller('ServiceRecordCtrl', ServiceRecordCtrl);
    }

    constructor($scope:any, $todo:any) {

        this.$scope = $scope;
        this.$todo = $todo;

        this.labelNewTodo = "";
        this.list = $todo.list;
        this.showMode = $todo.showMode;
        this.countTasksRemaining = $todo.countTasksRemaining;
        this.remove = $todo.remove;

    }

    /**
     * Adds a new todo, clears text in entry box
     */
    add() {

        this.$todo.add(this.labelNewTodo);
        this.labelNewTodo = "";

    }

};

export = ServiceRecordCtrl;

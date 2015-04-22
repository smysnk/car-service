/// <reference path="../../typings/tsd.d.ts" />

declare var require:any;
import ServiceRecord = require('../model/service_record.model');

class ServiceRecordService {

    private list = [];
    public showMode = {
        selected: null
    };

    public static initailize(mod: angular.IModule) {
        mod.service('$serviceRecord', ServiceRecordService);
    }

    /**
     * Add a new Todo item
     */
    add(title) {

        this.list.unshift(new ServiceRecord(title));

    }

    /**
     * Remove an existing todo item
     */
    remove (todo) {

        var index = this.list.indexOf(todo);
        if (index > -1) this.list.splice(index, 1);

    }

    /**
     * Returns the number of tasks remaining
     */
    countTasksRemaining() {

        var tasksRemaining = this.list.length;
        for (var i = 0, length = tasksRemaining; i < length; i++) {
            if (this.list[i].completed) tasksRemaining--;
        }
        return tasksRemaining;

    }

}

export = ServiceRecordService;
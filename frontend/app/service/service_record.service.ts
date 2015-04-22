/// <reference path="../../typings/tsd.d.ts" />

declare var require:any;
import ServiceRecord = require('../model/service_record.model');
var JsonHalAdapter = require('traverson-hal');

class ServiceRecordService {

    private list = [];
    public showMode = {
        selected: null
    };

    public static initailize(mod: angular.IModule) {
        mod.service('$serviceRecord', ServiceRecordService);
    }

    public static $inject = [
        'traverson'
    ];

    constructor(traverson) {

        traverson.registerMediaType(JsonHalAdapter.mediaType, JsonHalAdapter);

        traverson
            .from('http://localhost:9000/api/')
            .newRequest()
            .follow('serviceRecords')
                .getResource()
                .result
                .then(function(document) {
                    console.log('We have followed the path and reached our destination.')
                    console.log(JSON.stringify(document))
                }, function(err) {
                    console.error(err, 'No luck');
                });

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
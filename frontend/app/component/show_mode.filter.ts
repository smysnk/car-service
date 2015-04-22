/// <reference path="../../typings/tsd.d.ts" />

declare var require:any;

class ShowModeFilter {

    public static $inject = [
        '$serviceRecord'
    ];

    public static initailize(mod) {
        mod.filter('showModeFilter', ShowModeFilter);
    }

    constructor($serviceRecord:any) {

        return function(items) {

            var filtered = [];
            angular.forEach(items, function(item) {

                if ($serviceRecord.showMode.selected.filter(item)) {
                    filtered.push(item);
                }
            });
            return filtered;

        }

    }

}

export = ShowModeFilter;
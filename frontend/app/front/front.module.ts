declare var require:any;
import angular = require('angular');
import ModuleBuilder = require('../lib/ModuleBuilder');


class Module {

    constructor(parentBuilder: ModuleBuilder) {

        // Create module and hook it up to parent app module
        var moduleBuilder = new ModuleBuilder('front', [], parentBuilder);

        // Add our name as a module to load in the parent application
        parentBuilder.addDependency(moduleBuilder);

        var mod = moduleBuilder.build();
        require('./service_record.controller').initailize(mod);

        mod
            .config([
                '$stateProvider',
                function($stateProvider) {

                    // Now set up the states
                    $stateProvider
                        .state('front', {
                            url: '/',
                            templateUrl: 'front/panel.html',
                            controller: function ($scope, $state) {
                                if ($state.is('front')) {
                                    $state.go('front.serviceRecord');
                                }
                            }
                        })
                            .state('front.serviceRecord', {
                                url: 'service-record',
                                templateUrl: 'front/service_record.html',
                                controller: 'ServiceRecordCtrl',
                                controllerAs: 'sr'
                            })
                            .state('front.customer', {
                                url: 'customer',
                                templateUrl: 'front/customer.html',
                                controller: 'ServiceRecordCtrl',
                                controllerAs: 'sr'
                            })
                            .state('front.car', {
                                url: 'car',
                                templateUrl: 'front/car.html',
                                controller: 'ServiceRecordCtrl',
                                controllerAs: 'sr'
                            });

                }
            ]);


    }

}

export = Module;
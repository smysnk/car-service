/// <reference path="../typings/tsd.d.ts" />

declare var require:any;
import angular = require('angular');
import ModuleBuilder = require('./lib/ModuleBuilder');

// Load angular modules
require('angular-ui-router');
require('./templates');

// Wire up Traverson
//var traverson = require('traverson');
var traversonAngular = require('traverson-angular');

// Main app builder
var appBuilder = new ModuleBuilder('amt', ['ui.router', 'templates', traversonAngular.name]);

// Wire up or modules
require('./component/component.module')(appBuilder);
require('./service/service.module')(appBuilder);
require('./front/front.module')(appBuilder);

appBuilder
    .build()
    .config([
        '$urlRouterProvider',
        '$stateProvider',
        '$locationProvider',
        function($urlRouterProvider, $stateProvider, $locationProvider) {

            $locationProvider
                .html5Mode({ enabled: true })
                .hashPrefix('!');

            // For any unmatched url, redirect to 404 Not Found page.
            $urlRouterProvider
                .otherwise('/404');

            // Now set up the states
            $stateProvider
                .state('404', {
                    url: "/404",
                    templateUrl: "common/404.html"
                });

        }
    ]);

// Start the application!
angular.bootstrap(document, [appBuilder.getModuleName()]);

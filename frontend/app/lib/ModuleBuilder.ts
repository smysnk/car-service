/// <reference path="../../typings/tsd.d.ts" />

declare var require:any;
import angular = require('angular');

class ModuleBuilder {

    private moduleName: string;
    private moduleDependencies: string[];
    private moduleAngular: angular.IModule;
    private parentModuleBuilder: ModuleBuilder;

    constructor(moduleName: string, moduleDependencies: string[], parentModuleBuilder?: ModuleBuilder) {

        this.moduleName = moduleName;
        this.moduleDependencies = moduleDependencies;
        this.parentModuleBuilder = parentModuleBuilder;

    }

    public build() : angular.IModule {

        this.moduleAngular =  angular.module(this.moduleName, this.moduleDependencies);

        if (this.parentModuleBuilder) {
            angular.module(this.moduleName).requires.push(this.parentModuleBuilder.getModuleName());
        }

        return this.moduleAngular;

    }

    public addDependency(depdency: ModuleBuilder) {

        this.moduleDependencies.push(depdency.getModuleName());

    }

    public getModuleName() : string {

        return this.moduleName;

    }

    public getModule() : angular.IModule {

        if (!this.moduleAngular) {
            throw new Error("Get module called before initialization!")
        }

        return this.moduleAngular;

    }

}

export = ModuleBuilder;

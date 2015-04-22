declare var require:any;
import ModuleBuilder = require('../lib/ModuleBuilder');

class Module {

    constructor(parentBuilder: ModuleBuilder) {

        // Create module and hook it up to parent app module
        var moduleBuilder = new ModuleBuilder('component', [], parentBuilder);

        // Add our name as a module to load in the parent application
        parentBuilder.addDependency(moduleBuilder);

        var mod = moduleBuilder.build();
        require('./show_mode.filter').initailize(mod);
        require('./show_mode_select.directive').initailize(mod);

    }

}

export = Module;
package com.razorfish.test.core;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognifide.slice.api.context.ContextScope;
import com.cognifide.slice.api.injector.InjectorRunner;
import com.cognifide.slice.commons.SliceModulesFactory;
import com.cognifide.slice.core.internal.context.SliceContextScope;
import com.cognifide.slice.cq.module.CQModulesFactory;
import com.cognifide.slice.validation.ValidationModulesFactory;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Activator implements BundleActivator {

	private static final Logger LOG = LoggerFactory.getLogger(Activator.class);
	
	private static final String INJECTOR_NAME = "injectorName";
    private static final String BUNDLE_NAME_FILTER = "com\\.razorfish\\.test\\..*";
    private static final String BASE_PACKAGE = "com.razorfish.test";
	
	@Override
	public void start(BundleContext context) throws Exception {
		LOG.info("start ...");
		final ContextScope scope = new SliceContextScope();
        final InjectorRunner injectorRunner = new InjectorRunner(context, INJECTOR_NAME, scope);
        
        List<Module> sliceModules = SliceModulesFactory.createModules(context, INJECTOR_NAME, BUNDLE_NAME_FILTER, BASE_PACKAGE);
        List<Module> cqModules = CQModulesFactory.createModules();
        List<Module> validationModules = ValidationModulesFactory.createModules();
        // List<Module> customModules = createCustomModules();

        injectorRunner.installModules(sliceModules);
        injectorRunner.installModules(cqModules);
        injectorRunner.installModules(validationModules);
        // injectorRunner.installModules(customModules);
        
        Injector injector = Guice.createInjector();

        injectorRunner.start();
        TextModel model = injector.getInstance(TextModel.class);
        LOG.info("done ...");
	}
	
	private List<Module> createCustomModules() {
        List<Module> applicationModules = new ArrayList<Module>();
        //populate list with your modules
        Module myModule = new Module() {

			@Override
			public void configure(Binder arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        };
        return applicationModules;
    }
	
	@Override
	public void stop(BundleContext context) throws Exception {
		LOG.info("stop ...");
	}

}

package com.razorfish.test.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognifide.slice.mapper.annotation.JcrProperty;
import com.cognifide.slice.mapper.annotation.SliceResource;
import com.day.cq.wcm.api.PageManager;
import com.google.inject.Inject;

@SliceResource
public class TextModel {
	
	private static final Logger LOG = LoggerFactory.getLogger(TextModel.class);
	
	@JcrProperty
	private String text;
	
	private final PageManager pageManager = null;
	
	// @Inject
	public TextModel(/* PageManager pageManager */) {
		LOG.info("constructor ...");
		// this.pageManager = pageManager;
	}
	
	public String getText() {
		return text;
	}

}

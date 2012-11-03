package com.transrowi.taller.persistence;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.transrowi.taller.domain.Sequence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-applicationContext.xml"})
@Transactional
public class SequenceMapperTest {
	private Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private SequenceMapper sequenceMapper;
	
	private Sequence sequence;
	
	@Test
	public void getSequenceTest(){
		sequence = new Sequence();
		sequence.setNombre("familianum");
		sequence = sequenceMapper.getSequence(sequence);
		Assert.assertNotNull(sequence.getNextId());
		log.info(sequence.getNextId());
	}
	
	@Test
	public void updateSequenceTest(){
		sequence = sequenceMapper.getSequence(new Sequence("gruponum", null));
		Assert.assertNotNull(sequence);
		log.info(sequence.getNextId());
		sequence.setNextId(5L);
		log.info(sequence.getNextId());
		
		sequenceMapper.updateSequence(sequence);
		sequence = null; 
		sequence = sequenceMapper.getSequence(new Sequence("gruponum", null));
		log.info(sequence.getNextId());
	}
}
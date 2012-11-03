package com.transrowi.taller.persistence;

import com.transrowi.taller.domain.Sequence;

public interface SequenceMapper {
	Sequence getSequence(Sequence sequence);
	void updateSequence(Sequence sequence);
}

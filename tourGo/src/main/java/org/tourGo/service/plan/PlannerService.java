package org.tourGo.service.plan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.tourGo.models.entity.user.User;
import org.tourGo.models.plan.PlannerRq;
import org.tourGo.models.plan.entity.Planner;

@Service
public class PlannerService {

	@Autowired
	private PlannerRepository repository;
	
	public List<Planner> userPlanner(String userId){ //db로부터 플래너 번호를 내림차순하여 planner List형태로 변환하는 메서드


		
		List<Planner> list = repository.findAllByUser(userId,Sort.by(Sort.Direction.DESC,"plannerNo"));

		return list;
	}
	
	
	
}

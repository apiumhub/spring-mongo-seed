package com.apiumtech.controller;

import java.util.List;

import com.apiumtech.application.PingSystem;
import com.apiumtech.controller.base.SecureController;
import com.apiumtech.controller.forms.PingForm;
import com.apiumtech.domain.ping.Ping;
import com.apiumtech.domain.ping.PingService;
import com.apiumtech.infrastructure.ping.MongoPingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by roman on 18/01/16.
 */
@Controller
public class PingController extends SecureController {
	@Autowired
	private MongoTemplate mongoTemplate;

	private MongoPingRepository repository() {
		return new MongoPingRepository(this.mongoTemplate);
	}

	private PingService service() {
		return new PingService(repository());
	}

	private PingSystem system() {
		return new PingSystem(service());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/ping/{name}")
	public String pingOk(@PathVariable("name") String name, Model model) {
		Ping ping = this.system().findByName(name);
		model.addAttribute("ping", ping);
		return "ping/index";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/ping")
	public String pingList(Model model) {
		List<Ping> pings = this.system().findAll();
		model.addAttribute("pingList", pings);
		return "ping/pingList";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/ping", consumes = "application/json")
	public String pingSaved(@RequestBody PingForm form, Model model) {
		Ping ping = system().create(form.getName());
		model.addAttribute("ping", ping);
		return "ping/pingSaved";
	}
}

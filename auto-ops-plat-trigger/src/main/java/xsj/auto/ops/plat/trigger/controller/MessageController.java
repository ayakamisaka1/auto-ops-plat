package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.MessageServiceApi;
import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;
import xsj.auto.ops.plat.application.entityCase.MessageService;

import java.util.List;

@RestController
@RequestMapping("/memory/message")
@RequiredArgsConstructor
public class MessageController implements MessageServiceApi {

    private final MessageService messageService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<MessageResponse>> list() {
        return messageService.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<MessageResponse> getById(@PathVariable Long id) {
        return messageService.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<MessageResponse> create(@RequestBody MessageRequest request) {
        return messageService.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<MessageResponse> update(@RequestBody MessageRequest request) {
        return messageService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return messageService.delete(id);
    }
}

package self.jason.study.easyui;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Paging<T> {
	private long total;
	private List<T> rows;
	private List<?> footer;
}

package it.braccosoft.imdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import it.braccosoft.imdb.bean.MyMovies;
import it.braccosoft.imdb.service.MyMoviesService;

import com.vaadin.spring.annotation.SpringUI;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

	@Autowired
	private MyMoviesService service;

	private MyMovies myMovie;

	private Grid grid = new Grid();
	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private Button save = new Button("Save", e -> saveCustomer());

	@Override
	protected void init(VaadinRequest request) {
		updateGrid();
		grid.setColumns("Cover","ID", "Title","imdb_link","Data");
		grid.addSelectionListener(e -> updateForm());
		VerticalLayout layout = new VerticalLayout(grid, firstName, lastName, save);
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
	}
	
	private void updateGrid() {
        List<MyMovies> movies = service.findAll();
        grid.setContainerDataSource(new BeanItemContainer<MyMovies>(MyMovies.class, movies));
        setFormVisible(false);
    }

    private void updateForm() {
        if (grid.getSelectedRows().isEmpty()) {
            setFormVisible(false);
        } else {
        	myMovie = (MyMovies) grid.getSelectedRow();
            BeanFieldGroup.bindFieldsUnbuffered(myMovie, this);
            setFormVisible(true);
        }
    }

    private void setFormVisible(boolean visible) {
        firstName.setVisible(visible);
        lastName.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCustomer() {
        //service.update(myMovie);
        updateGrid();
    }

}

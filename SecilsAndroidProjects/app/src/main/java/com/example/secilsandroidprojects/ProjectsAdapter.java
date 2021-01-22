package com.example.secilsandroidprojects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ProjectViewHolder> {

    private Project[] projects;

    public ProjectsAdapter(Project[] projects) {
        this.projects = projects;
    }

    @Override
    public int getItemCount() {
        return projects.length;
    }

    @NonNull
    @NotNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_project, parent, false);
        return new ProjectViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull ProjectViewHolder holder, int position) {
        holder.bind(projects[position]);
    }

    static class ProjectViewHolder extends RecyclerView.ViewHolder {

        private ImageView appImage;
        private TextView appTitle;
        private TextView appDescription;

        public ProjectViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            appImage = itemView.findViewById(R.id.image_view_project_icon);
            appDescription = itemView.findViewById(R.id.text_view_project_description);
            appTitle = itemView.findViewById(R.id.text_view_project_title);
        }

        public void bind(Project project){
            appTitle.setText(project.name);
            appDescription.setText(project.description);
            appImage.setImageResource(project.image);
        }
    }

}

//
//  NoteDetailViewModel.swift
//  ios
//
//  Created by Владимир Тамбовцев on 24.10.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

extension NoteDetailScreen {
    class NoteDetailViewModel: ObservableObject {
        private var noteDataSource: NoteDataSource?
        
        private var noteId: Int64? = nil
        @Published var noteTitle = ""
        @Published var noteContent = ""
        @Published private(set) var noteColor = Note.Companion().generateColor()
        
        init(noteDataSource: NoteDataSource? = nil) {
            self.noteDataSource = noteDataSource
        }
        
        func loadNoteIfExists(id: Int64?) {
            if id != nil {
                self.noteId = id
                noteDataSource?.getNoteById(id: id!, completionHandler: { note, err in
                    self.noteTitle = note?.title ?? ""
                    self.noteContent = note?.content ?? ""
                    self.noteColor = note?.colorHex ?? Note.Companion().generateColor()
                })
            }
        }
        
        func saveNote(onSaved: @escaping () -> Void) {
            noteDataSource?.insertNote(note: Note(id: noteId == nil ? nil : KotlinLong(value: noteId!), title: self.noteTitle, content: self.noteContent, colorHex: self.noteColor, created: DateTimeUtil().now()), completionHandler: { err in
                if err != nil {
                    print("Err saving note: \(String(describing: err?.localizedDescription))")
                }
                onSaved()
            })
        }
        
        func setParamsAndLoadNote(noteDataSource: NoteDataSource, noteId: Int64?) {
            self.noteDataSource = noteDataSource
            loadNoteIfExists(id: noteId)
        }
    }
}

/*
 * Artifactural
 * Copyright (c) 2018.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package com.amadornes.artifactural.api.repository;

import com.amadornes.artifactural.api.artifact.Artifact;

import java.util.function.Function;
import java.util.function.Predicate;

public interface ArtifactProvider<I> {

    Artifact getArtifact(I info);

    interface Builder<S, I> {

        Builder<S, I> filter(Predicate<I> filter);

        <D> Builder<S, D> mapInfo(Function<I, D> mapper);

        Complete<S, I> provide(ArtifactProvider<I> provider);

        interface Complete<S, I> extends ArtifactProvider<S> {

            Complete<S, I> provide(ArtifactProvider<I> provider);

        }

    }

}
